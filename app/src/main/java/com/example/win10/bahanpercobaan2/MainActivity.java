package com.example.win10.bahanpercobaan2;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        // Menginisiasi  NavigationView
        NavigationView navigationView = findViewById(R.id.nav_view);
        //Mengatur Navigasi View Item yang akan dipanggil untuk menangani item klik menu navigasi
        navigationView.setNavigationItemSelectedListener(this);

        // VALUE VIEW AKAN MEMBUAT BACKGROUND SESUAI WARNA
        view    =   this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.bagfragdas);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Sidebar_Dasboard_Fragment()).commit();

            // Membuat halaman pertama yang dibuka adalah nav_dasbor
            navigationView.setCheckedItem(R.id.nav_dasbor);
        }
    }

    // Metod ini akan memicu item Klik menu navigasi
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Memeriksa untuk melihat item yang akan dilklik dan melalukan aksi
        switch (item.getItemId()) {
            // pilihan menu item navigasi akan menampilkan sesuai halaman pilihan ketika di klik

            case R.id.nav_dasbor:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Sidebar_Dasboard_Fragment()).commit();
                break;

            case R.id.nav_pertanian:
                Intent page2 = new Intent(getApplicationContext(),Sidebar_Pertanian.class);
                startActivity(page2);
                break;

            /*case R.id.nav_pertanian:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Sidebar_Pertanian_Fragment()).commit();
                break;*/

            /*case R.id.nav_perkebunan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new perkebunan_fragment()).commit();
                break;
            case R.id.nav_perhutanan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new perhutanan_fragment()).commit();
                break;*/
        }
        // Kode di sini akan merespons setelah drawer menutup disini kita biarkan kosong
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Mengatur Button Warna setelah di pencet (On Click)
    public void birutua(View view){
        view.setBackgroundResource(R.color.bagtoolbar);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
