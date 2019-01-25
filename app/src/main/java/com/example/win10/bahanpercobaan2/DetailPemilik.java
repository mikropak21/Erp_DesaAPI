package com.example.win10.bahanpercobaan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailPemilik extends AppCompatActivity
{
    TextView pemilik,luas,tgl_tanam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Akan menampilkan page/layout pada activity_main4
        setContentView(R.layout.pagepemilik);

        Intent result = getIntent();

        pemilik = (TextView)findViewById(R.id.formPemilik);

        tgl_tanam   =   (TextView) findViewById(R.id.formtanggal);

        luas        =   (TextView) findViewById(R.id.formluaslahan);

        String nilailuaslahan   = result.getExtras().getString("luas_lahan");
        String nilaitgltanam    = result.getExtras().getString("tgl_tanam");
        String nilaipemilik     = result.getExtras().getString("pemilik");

        tgl_tanam.setText(nilaitgltanam);
        pemilik.setText(nilaipemilik);
        luas.setText(nilailuaslahan);

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
