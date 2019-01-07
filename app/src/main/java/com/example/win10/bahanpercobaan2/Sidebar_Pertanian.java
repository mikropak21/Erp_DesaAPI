package com.example.win10.bahanpercobaan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Sidebar_Pertanian extends AppCompatActivity {
    // Buat value button
    private RelativeLayout padi;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Value button yang berisi ID  =   button2
        padi =(RelativeLayout) findViewById(R.id.onclickpad);

        padi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpagepadi();
            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabsideper);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bukaTambah();
            }
        });
    }

    public void bukaTambah(){
        Intent tambah = new Intent(getApplicationContext(),TambahActivity.class);
        startActivity(tambah);
    }

    public void openpagepadi() {
        Intent open = new Intent(this, Pertanian_Detailpadi.class);
        startActivity(open);
    }
}
