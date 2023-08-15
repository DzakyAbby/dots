package com.example.dots;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.annotations.SerializedName;

public class Hero extends AppCompatActivity {
    @SerializedName("name")
    private String name;

    @SerializedName("bio")
    private String bio;

    @SerializedName("image")
    private String image;
    private float id;

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }


    public int getId() {
        return (int) id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
