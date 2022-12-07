package com.example.crmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class question extends AppCompatActivity {
ConstraintLayout j;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
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
        setContentView(R.layout.question);
j=findViewById(R.id.j);
j.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

                startActivity(new Intent(question.this, contact.class));

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
                        startActivity(new Intent(question.this, Accueil.class));
                        break;
                    }
                    case R.id.proc: {
                        startActivity(new Intent(question.this, proc.class));
                        break;
                    }
                    case R.id.gallery: {
                        startActivity(new Intent(question.this, PageFormation.class));
                        break;
                    }
                    case R.id.about: {
                        startActivity(new Intent(question.this, Documentation.class));
                        break;
                    }
                    case R.id.login: {
                        startActivity(new Intent(question.this, contact.class));
                        break;
                    }
                    case R.id.share: {
                        startActivity(new Intent(question.this, question.class));
                        break;
                    }
                    case R.id.rate: {
                        startActivity(new Intent(question.this, Blog.class));
                        break;
                    }
                    case R.id.inscrite: {
                        startActivity(new Intent(question.this, frminscription.class));
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
