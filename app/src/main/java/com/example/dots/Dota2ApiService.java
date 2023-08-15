package com.example.dots;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.Contract;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;

public interface Dota2ApiService {
    @Nullable
    @Contract(pure = true)
    @Headers({
            "X-RapidAPI-Key: 8916cb49c8msha1c0d9f5ef2e51bp12c509jsn69c39305e539",
            "X-RapidAPI-Host: dota2-heroes.p.rapidapi.com"
    })
    @GET("heroes/id/english")
    Call<List<Hero>> getHeroes();
}
