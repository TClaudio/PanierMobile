package com.example.paniermobil.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.paniermobil.R;
import com.example.paniermobil.fragments.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.paniermobil.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    ProgressBar progressBar;                       
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    FirebaseAuth auth;

    Toolbar toolbar;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu);
        homeFragment = new HomeFragment();
        loadFragment(homeFragment);
    }


    private void loadFragment(Fragment homeFragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container,homeFragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, UserProfile.class));
                return true;
            case R.id.nav_product:
                Toast.makeText(this, "Nouveau Produit", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, NewProduct.class));
                return true;
        }
            return super.onOptionsItemSelected(item);
    }


        //    public boolean onOptionItemSelected(MenuItem item){
//        this.item = item;
//        switch (item.getItemId()){
//            case R.id.nav_profile:
//                Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(MainActivity.this,MainActivity.class));
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if ( id == R.id.menu_logout){
//            auth.signOut();
//            startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
//            finish();
//        }else if(id == R.id.menu_cart){
//            startActivity(new Intent(MainActivity.this,CartActivity.class));

}
