package com.example.crmapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class suc extends AppCompatActivity {

ImageButton fac,insta,linkd,what1;
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
        setContentView(R.layout.najah);
        fac=findViewById(R.id.f);
        insta=findViewById(R.id.i);
        linkd=findViewById(R.id.l);
        what1=findViewById(R.id.w1);
        what1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://wa.me/+212661103143?text=Hi,Is any one Available?";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://web.facebook.com/ir.skills?_rdc=1&_rdr";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/ir.skills.officiel/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        linkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.linkedin.com/company/ir-skills-officiel/";

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
                        startActivity(new Intent(suc.this, Accueil.class));
                        break;
                    }
                    case R.id.proc: {
                        startActivity(new Intent(suc.this, proc.class));
                        break;
                    }
                    case R.id.gallery: {
                        startActivity(new Intent(suc.this, PageFormation.class));
                        break;
                    }
                    case R.id.about: {
                        startActivity(new Intent(suc.this, Documentation.class));
                        break;
                    }
                    case R.id.login: {
                        startActivity(new Intent(suc.this, contact.class));
                        break;
                    }
                    case R.id.share: {
                        startActivity(new Intent(suc.this, question.class));
                        break;
                    }
                    case R.id.rate: {
                        startActivity(new Intent(suc.this, Blog.class));
                        break;
                    }
                    case R.id.inscrite: {
                        startActivity(new Intent(suc.this, frminscription.class));
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
