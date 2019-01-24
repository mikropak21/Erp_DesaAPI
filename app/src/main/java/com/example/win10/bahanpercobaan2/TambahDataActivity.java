package com.example.win10.bahanpercobaan2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*import com.example.win10.bahanpercobaan2.Function.Repository;*/
import com.example.win10.bahanpercobaan2.MyGreenDao.AppController;
import com.example.win10.bahanpercobaan2.TableDb.DaoMaster;
import com.example.win10.bahanpercobaan2.TableDb.DaoSession;
import com.example.win10.bahanpercobaan2.TableDb.Padi;
import com.example.win10.bahanpercobaan2.TableDb.PadiDao;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.database.Database;

public class TambahDataActivity extends AppCompatActivity {

    Button submit;
    EditText
            luaslahanpadi,tgl_tanam,tgl_siappanen,hasilpanen,pemilikpadi,nik,j_pekerja;

    DaoSession daoSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        submit = (Button) findViewById(R.id.subdata);

        luaslahanpadi = findViewById(R.id.luaslahan);

        tgl_tanam = findViewById(R.id.tgl_tanama);

        tgl_siappanen = findViewById(R.id.tgl_siap);

        hasilpanen = findViewById(R.id.hasil_panen);

        pemilikpadi = findViewById(R.id.nama_pemilik);

        nik = findViewById(R.id.nik);

        j_pekerja = findViewById(R.id.jml_tenaga);

        daoSession = ((AppController) getApplication()).getDaoSession();


        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PadiDao padiDao =   daoSession.getPadiDao();
                        //create new object
                        Padi padi=new Padi();
                        //set value to object attribute
                        padi.setHasilpanen(hasilpanen.getText().toString().trim());
                        padi.setPemilik(pemilikpadi.getText().toString().trim());
                        padi.setLuaslahan(Integer.parseInt(luaslahanpadi.getText().toString()));
                        padi.setTgl_tanam(tgl_tanam.getText().toString());
                        padi.setTgl_siappanen(tgl_siappanen.getText().toString());
                        padi.setNik(Integer.parseInt(nik.getText().toString()));
                        padi.setJ_pekerja(Integer.parseInt(j_pekerja.getText().toString()));
                        //insert data to database
                        padiDao.insert(padi);
                        Toast.makeText(TambahDataActivity.this,"berhasil memasukkan data",Toast.LENGTH_LONG).show();
                        //  Membuat aktivity kita kembali ke activity dimana sebelum mau menginput
                        finish();
                    }
                });

    }

}