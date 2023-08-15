package com.example.dots;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ApiClient {

    private static final String BASE_URL = "https://dota2-heroes.p.rapidapi.com/";

    private final Dota2ApiService apiService;

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(Dota2ApiService.class);
    }

    public List<Hero> getHeroes() throws IOException {
        Call<List<Hero>> call = apiService.getHeroes();
        retrofit2.Response<List<Hero>> response = call.execute();

        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new IOException("Request failed with code: " + response.code());
        }
    }

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        try {
            List<Hero> heroes = apiClient.getHeroes();
            for (Hero hero : heroes) {
                System.out.println("Hero Name: " + hero.getName());
                System.out.println("Hero Bio: " + hero.getBio());
                System.out.println("Hero Image: " + hero.getImage());
                System.out.println("-----------");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
