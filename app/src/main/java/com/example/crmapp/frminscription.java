package com.example.crmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frminscription extends AppCompatActivity {


    public ConstraintLayout b33;
    public EditText e11,e22,e44,e33;

    public FirebaseAuth fr;
    private FirebaseDatabase database;
    private DatabaseReference myRef,mn;
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
        setContentView(R.layout.frminscription);
        // getActionBar().hide();
        b33 = findViewById(R.id.b3);
        e11=findViewById(R.id.e1);
        e22=findViewById(R.id.e2);
        e44=findViewById(R.id.e4);
        e33=findViewById(R.id.e3);

        fr=FirebaseAuth.getInstance();

//button pour l'enregistrement
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                myRef=database.getReference("Clients");
                //Get all vallues
                String email= e22.getText().toString().trim();
                if(email.isEmpty()) {
                    e22.setError("plz enter your email");
                    return;
                }
                String nom=e11.getText().toString().trim();
                if(nom.isEmpty()) {
                    e11.setError("plz enter your name");
                    return;
                }
                String numero=e44.getText().toString().trim();
                if(numero.isEmpty()) {
                    e44.setError("plz enter your numero");
                    return;
                }
                String formation=e33.getText().toString().trim();
                if(formation.isEmpty()) {
                    e33.setError("plz enter your formation");
                    return;
                }
                clients cl=new clients(nom,email,numero,formation);
                myRef.child(nom).setValue(cl);
               // myRef=database.getReference("Users");
               // clients cl1=new clients(nom,email,numero,formation);
               // myRef.child(nom).setValue(cl1);
                Toast.makeText(frminscription.this, "Bien Enregistre", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), suc1.class));


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
                        startActivity(new Intent(frminscription.this, Accueil.class));
                        break;
                    }
                    case R.id.proc: {
                        startActivity(new Intent(frminscription.this, proc.class));
                        break;
                    }
                    case R.id.gallery: {
                        startActivity(new Intent(frminscription.this, PageFormation.class));
                        break;
                    }
                    case R.id.about: {
                        startActivity(new Intent(frminscription.this, Documentation.class));
                        break;
                    }
                    case R.id.login: {
                        startActivity(new Intent(frminscription.this, contact.class));
                        break;
                    }
                    case R.id.share: {
                        startActivity(new Intent(frminscription.this, question.class));
                        break;
                    }
                    case R.id.rate: {
                        startActivity(new Intent(frminscription.this, Blog.class));
                        break;
                    }
                    case R.id.inscrite: {
                        startActivity(new Intent(frminscription.this, frminscription.class));
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
