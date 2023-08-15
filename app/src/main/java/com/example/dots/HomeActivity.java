package com.example.dots;

import android.os.Bundle;
import static com.example.dots.R.layout.activity_hero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.NavigationUI;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_hero);
        BottomNavigationView BottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);

        NavigationUI.setupWithNavController(BottomNavigationView, navController);
    }
}
