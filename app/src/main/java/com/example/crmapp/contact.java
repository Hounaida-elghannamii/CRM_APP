package com.example.crmapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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


public class contact extends AppCompatActivity {
EditText em1,em2,em3,em4;
ConstraintLayout bm;
ImageButton fac,insta,linkd,what1;
    public FirebaseAuth fr;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
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
        setContentView(R.layout.contact);
      fac=findViewById(R.id.fac1);
      insta=findViewById(R.id.insta1);
      linkd=findViewById(R.id.linkd1);
        em1=findViewById(R.id.em1);
        em2=findViewById(R.id.em2);
        em3=findViewById(R.id.em3);
        em4=findViewById(R.id.em4);
        what1=findViewById(R.id.what1);
        bm=findViewById(R.id.bm);
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

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                myRef=database.getReference("Contact");
                //Get all vallues
                String name= em1.getText().toString().trim();
                if(name.isEmpty()) {
                    em1.setError("plz enter your name");
                    return;
                }
                String gmail=em2.getText().toString().trim();
                if(gmail.isEmpty()) {
                    em2.setError("plz enter your gmail");
                    return;
                }
                String sujet=em3.getText().toString().trim();
                if(sujet.isEmpty()) {
                    em3.setError("plz enter your sujet");
                    return;
                }
                String msj=em4.getText().toString().trim();
                if(msj.isEmpty()) {
                    em4.setError("plz enter your msj");
                    return;
                }
                msjcontact ms=new msjcontact(name,gmail,sujet,msj);
                myRef.child(sujet).setValue(ms);
                Toast.makeText(contact.this, "Bien Enregistre", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(contact.this, suc.class));

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
                        startActivity(new Intent(contact.this, Accueil.class));
                        break;
                    }
                    case R.id.proc: {
                        startActivity(new Intent(contact.this, proc.class));
                        break;
                    }
                    case R.id.gallery: {
                        startActivity(new Intent(contact.this, PageFormation.class));
                        break;
                    }
                    case R.id.about: {
                        startActivity(new Intent(contact.this, Documentation.class));
                        break;
                    }
                    case R.id.login: {
                        startActivity(new Intent(contact.this, contact.class));
                        break;
                    }
                    case R.id.share: {
                        startActivity(new Intent(contact.this, question.class));
                        break;
                    }
                    case R.id.rate: {
                        startActivity(new Intent(contact.this, Blog.class));
                        break;
                    }
                    case R.id.inscrite: {
                        startActivity(new Intent(contact.this, frminscription.class));
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
