package com.example.win10.bahanpercobaan2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class DetailPemilik extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Akan menampilkan page/layout pada activity_main4
        setContentView(R.layout.activity_main4);

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
