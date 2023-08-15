package com.example.dots;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DotaAdapter extends RecyclerView.Adapter<DotaAdapter.ViewHolder> {

    private final Context context;
    private final List<Hero> heroes;

    public DotaAdapter(Context context, List<Hero> heroes) {
        this.context = context;
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dota_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, Hero.class);
            Bundle bundle = new Bundle();
            bundle.putInt("hero_id", hero.getId());
            bundle.putString("hero_name", hero.getName());
            intent.putExtras(bundle);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView title;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.detail_poster);
            title = itemView.findViewById(R.id.main_title);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
