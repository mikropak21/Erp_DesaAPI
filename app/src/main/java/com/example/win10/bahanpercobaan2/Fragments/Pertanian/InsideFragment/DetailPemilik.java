package com.example.win10.bahanpercobaan2.Fragments.Pertanian.InsideFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win10.bahanpercobaan2.R;

import java.util.Objects;

//import com.example.win10.bahanpercobaan2.TableDb.DbPadi;
//import com.example.win10.bahanpercobaan2.TableDb.PadiDao;

public class DetailPemilik extends AppCompatActivity
{
    TextView pemilik,luas,tgl_tanam,tgl_siappanen,hasil_panen,j_pekerja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Akan menampilkan page/layout
        setContentView(R.layout.pagepemilik);


        /**
         *  Akan membuat action back ke parent atau ke halaman sebelumnya
         * */



        /**
         *  Instansi intent agar bisa dipanggil di class ini
         * */
        Intent result = getIntent();
        pemilik         = (TextView)findViewById(R.id.formPemilik);
        luas            =   (TextView) findViewById(R.id.formluaslahan);
        tgl_tanam       =   (TextView) findViewById(R.id.formtanggal);
        tgl_siappanen   = (TextView) findViewById(R.id.formsiappanen);
        hasil_panen     = (TextView) findViewById(R.id.formhasilpanen);
        j_pekerja       = (TextView) findViewById(R.id.formjumlahtenagakerja);


        /**
         *  Variable nilai akan mendapatkan isi setelah menerima Key dari intent
         * */
        String nilailuaslahan       = result.getExtras().getString("luas_lahan");
        String nilaipemilik         = result.getExtras().getString("pemilik");
        String nilaisiappanen       = result.getExtras().getString("tgl_panen");
        String nilaihasilpanen      = result.getExtras().getString("hasil_panen");
        String nilaitanggaltanam    = result.getExtras().getString("tgl_tanam");
        String nilaijmlpekerja      = result.getExtras().getString("jumlah_pekerja");

        Toolbar toolbar     =   findViewById(R.id.toolbarpemilik);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Padi - "+nilaipemilik);
        toolbar.setTitleTextColor(Color.WHITE);
        /**
         *  Menampilkan nilai dari id dan variable yang ada, bisa juga kita tambahkan string tambahan
         * */
        j_pekerja.setText(nilaijmlpekerja+" Orang");
        tgl_siappanen.setText(nilaisiappanen);
        hasil_panen.setText(nilaihasilpanen+ " Juta Ton");
        tgl_tanam.setText(nilaitanggaltanam);
        pemilik.setText(nilaipemilik);
        luas.setText(nilailuaslahan+" ha");





        Bundle bundle   =   getIntent().getExtras();
        if (bundle  !=  null)
        {
            if(bundle.getString("some")   != null)
            {
                Toast.makeText(getApplicationContext(),"data"   +   bundle.getString("some"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
