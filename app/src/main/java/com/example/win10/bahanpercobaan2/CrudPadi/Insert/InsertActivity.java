package com.example.win10.bahanpercobaan2.CrudPadi.Insert;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.win10.bahanpercobaan2.API_Interface.API_Link.ApiClient;
import com.example.win10.bahanpercobaan2.API_Interface.API_CRUD.ApiInterface;
import com.example.win10.bahanpercobaan2.API_Interface.API_CRUD.CRUDPadi;
import com.example.win10.bahanpercobaan2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edtluas_lahan, edttgl_tanam, edttgl_siap_panen, edthasil_panen, edtpemilik, edtnik, edtpekerja;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        edtluas_lahan= (EditText) findViewById(R.id.luaslahan);

        edttgl_tanam = (EditText) findViewById(R.id.tgl_tanam);

        edttgl_siap_panen= (EditText) findViewById(R.id.tgl_siap);

        edthasil_panen = (EditText) findViewById(R.id.hasil_panen);

        edtpemilik= (EditText) findViewById(R.id.nama_pemilik);

        edtnik= (EditText) findViewById(R.id.nik);

        edtpekerja = (EditText) findViewById(R.id.jml_tenaga);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.subdata);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<CRUDPadi> postPadiCall = mApiInterface.postPadi(
                        Integer.parseInt(String.valueOf(edtluas_lahan.getText().toString())),
                        edttgl_tanam.getText().toString(),
                        edttgl_siap_panen.getText().toString(),
                        edthasil_panen.getText().toString(),
                        edtpemilik.getText().toString(),
                        Integer.parseInt(String.valueOf(edtnik.getText().toString())),
                        Integer.parseInt(String.valueOf(edtpekerja.getText().toString()))
                );
                postPadiCall.enqueue(new Callback<CRUDPadi>() {
                    @Override
                    public void onResponse(Call<CRUDPadi> call, Response<CRUDPadi> response) {
                        Toast.makeText(getApplicationContext(), "Berhasil coy", Toast.LENGTH_LONG).show();
                       /* MainActivity.ma.refresh();
                        finish();*/
                    }

                    @Override
                    public void onFailure(Call<CRUDPadi> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Berhasil coy", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
//
//        btBack = (Button) findViewById(R.id.btBackGo);
//        btBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.ma.refresh();
//                finish();
//            }
//        });
   }
}