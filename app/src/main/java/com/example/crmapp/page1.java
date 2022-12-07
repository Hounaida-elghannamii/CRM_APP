package com.example.crmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class page1 extends AppCompatActivity {
TextView tc7;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    FloatingActionButton fab;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
tc7=findViewById(R.id.tc9);
tc7.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(page1.this, Blog.class));
    }
});
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home: {
                        //Toast.makeText(MainActivity.this, "home selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(page1.this, Accueil.class));
                        break;
                    }
                    case R.id.proc: {
                        startActivity(new Intent(page1.this, proc.class));
                        break;
                    }
                    case R.id.gallery: {
                        startActivity(new Intent(page1.this, PageFormation.class));
                        break;
                    }
                    case R.id.about: {
                        startActivity(new Intent(page1.this, Documentation.class));
                        break;
                    }
                    case R.id.login: {
                        startActivity(new Intent(page1.this, contact.class));
                        break;
                    }
                    case R.id.share: {
                        startActivity(new Intent(page1.this, question.class));
                        break;
                    }
                    case R.id.rate: {
                        startActivity(new Intent(page1.this, Blog.class));
                        break;
                    }
                    case R.id.inscrite: {
                        startActivity(new Intent(page1.this, frminscription.class));
                        break;
                    }

                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
