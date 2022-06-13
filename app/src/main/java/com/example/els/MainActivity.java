package com.example.els;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.els.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.els.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setup Navigation components for main activity
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = binding.bottomNavigation;
        NavigationUI.setupWithNavController(bottomNav, navController);

        //set start destination
        NavInflater inflater = navHostFragment.getNavController().getNavInflater();
        NavGraph graph = inflater.inflate(R.navigation.nav_graph);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null ) {
            graph.setStartDestination(R.id.homeFragment);
        }

        // Set visibility for bottom navigation
        navController.addOnDestinationChangedListener((navController1, navDestination, bundle) -> {
            // If the destination is one of the four main page then show the bottom nav
            if (navDestination.getId() == R.id.homeFragment ||
                    navDestination.getId() == R.id.gamesFragment ||
                    navDestination.getId() == R.id.personalFragment ||
                    navDestination.getId() == R.id.meetingFragment) {
                bottomNav.setVisibility(View.VISIBLE);
            }  // else hide it
            else {
                bottomNav.setVisibility(View.GONE);
            }
        });
    }
}