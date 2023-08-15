package com.example.dots;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentListDota extends Fragment {

    private RecyclerView recyclerView;
    private DotaAdapter dotaAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentlist_dota, container, false);

        recyclerView = view.findViewById(R.id.rvhero);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiClient apiClient = new ApiClient();

        Call<List<Hero>> call = null;
        try {
            call = (Call<List<Hero>>) apiClient.getHeroes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Hero> heroes = response.body();

                    // Pastikan ada data sebelum memproses
                    if (!heroes.isEmpty()) {
                        dotaAdapter = new DotaAdapter(getContext(), heroes);
                        recyclerView.setAdapter(dotaAdapter);
                    } else {
                        // Tampilkan pesan bahwa tidak ada data yang ditemukan
                        Toast.makeText(getContext(), "No heroes data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Tangani jika respons tidak berhasil
                    // Misalnya: tampilkan pesan error atau log
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                // Tangani jika permintaan gagal
                // Misalnya: tampilkan pesan error atau log
            }
        });

        return view;
    }
}
