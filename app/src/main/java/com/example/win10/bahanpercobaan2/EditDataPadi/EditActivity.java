package com.example.win10.bahanpercobaan2.EditDataPadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.win10.bahanpercobaan2.ApiInterface.ApiClient;
import com.example.win10.bahanpercobaan2.ApiInterface.ApiInterface;
import com.example.win10.bahanpercobaan2.ApiInterface.CRUDPadi;
import com.example.win10.bahanpercobaan2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    EditText editpadi_id,edtluas_lahan, edttgl_tanam, edttgl_siap_panen, edthasil_panen, edtpemilik, edtnik, edtpekerja;
    Button btUpdate,btDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editactivity);

        editpadi_id = (EditText) findViewById(R.id.edit_idpadi) ;

        edtluas_lahan= (EditText) findViewById(R.id.edit_luaslahan);

        edttgl_tanam = (EditText) findViewById(R.id.edit_tgl_tanam);

        edttgl_siap_panen= (EditText) findViewById(R.id.edit_tgl_siap);

        edthasil_panen = (EditText) findViewById(R.id.edit_hasil_panen);

        edtpemilik= (EditText) findViewById(R.id.edit_nama_pemilik);

        edtnik= (EditText) findViewById(R.id.edit_nik);

        edtpekerja = (EditText) findViewById(R.id.edit_jml_tenaga);

        btUpdate = (Button) findViewById(R.id.edit_updatedata);

        Intent mIntent = getIntent();

        editpadi_id.setText(mIntent.getStringExtra("id"));
        editpadi_id.setTag(editpadi_id.getKeyListener());
        editpadi_id.setKeyListener(null);

        edtluas_lahan.setText(mIntent.getStringExtra("luas_lahan"));
        edttgl_tanam.setText(mIntent.getStringExtra("tgl_tanam"));
        edttgl_siap_panen.setText(mIntent.getStringExtra("tgl_siap_panen"));
        edthasil_panen.setText(mIntent.getStringExtra("hasil_panen"));
        edtpemilik.setText(mIntent.getStringExtra("pemilik"));
        edtnik.setText(mIntent.getStringExtra("nik"));
        edtpekerja.setText(mIntent.getStringExtra("pekerja"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<CRUDPadi> updatePadiCall = mApiInterface.putPadi(

                        Integer.parseInt(String.valueOf(edtluas_lahan.getText().toString())),
                        edttgl_tanam.getText().toString(),
                        edttgl_siap_panen.getText().toString(),
                        edthasil_panen.getText().toString(),
                        edtpemilik.getText().toString(),
                        Integer.parseInt(String.valueOf(edtnik.getText().toString())),
                        Integer.parseInt(String.valueOf(edtpekerja.getText().toString())),
                                Integer.parseInt(String.valueOf(editpadi_id.getText().toString()))
                );
                updatePadiCall.enqueue(new Callback<CRUDPadi>() {
                    @Override
                    public void onResponse(Call<CRUDPadi> call, Response<CRUDPadi> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<CRUDPadi> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.edit_deletedata);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editpadi_id.getText().toString().trim().isEmpty()){
                    Call<CRUDPadi> deletePadi = mApiInterface.deletePadi(editpadi_id.getText().toString());
                    deletePadi.enqueue(new Callback<CRUDPadi>() {
                        @Override
                        public void onResponse(Call<CRUDPadi> call, Response<CRUDPadi> response) {
                            finish();
                        }

                        @Override
                        public void onFailure(Call<CRUDPadi> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}