package com.example.crmapp;

import android.content.Intent;
import android.net.Uri;
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

public class Documentation extends AppCompatActivity {
    public ConstraintLayout btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
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
        setContentView(R.layout.documentation);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/Bienvenue-chez-ir-skills-...pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/Orange-Minimaliste-Rprise-des-cours-Bulletin-dinformation_10-1.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/IR-SKILLS-LKcoursecatalog-compresse-avec-compression.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/Orange-Minimaliste-Rprise-des-cours-Bulletin-dinformation_20.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/Formation-Electricite-Batiment-IRSKILLS-corrigee.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/IR-SKILLS-DIGITAL-MEDIA-1.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/IR-SKILLS-LEARNKEY-1.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://irskills.com/wp-content/uploads/2021/07/IR-SKILLS-GMetrixSMS_Guide_dutilisateur.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
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
                        startActivity(new Intent(Documentation.this, Accueil.class));
                        break;
                    }
                    case R.id.proc: {
                        startActivity(new Intent(Documentation.this, proc.class));
                        break;
                    }
                    case R.id.gallery: {
                        startActivity(new Intent(Documentation.this, PageFormation.class));
                        break;
                    }
                    case R.id.about: {
                        startActivity(new Intent(Documentation.this, Documentation.class));
                        break;
                    }
                    case R.id.login: {
                        startActivity(new Intent(Documentation.this, contact.class));
                        break;
                    }
                    case R.id.share: {
                        startActivity(new Intent(Documentation.this, question.class));
                        break;
                    }
                    case R.id.rate: {
                        startActivity(new Intent(Documentation.this, Blog.class));
                        break;
                    }
                    case R.id.inscrite: {
                        startActivity(new Intent(Documentation.this, frminscription.class));
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
