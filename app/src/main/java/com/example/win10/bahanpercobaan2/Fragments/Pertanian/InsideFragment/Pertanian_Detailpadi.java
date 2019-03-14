package com.example.win10.bahanpercobaan2.Fragments.Pertanian.InsideFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.win10.bahanpercobaan2.Adapter.AdapterPadi.MyAdapterPadi;
import com.example.win10.bahanpercobaan2.CrudPadi.Insert.InsertActivity;
import com.example.win10.bahanpercobaan2.Model.DbPadi;
import com.example.win10.bahanpercobaan2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pertanian_Detailpadi extends AppCompatActivity
{
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<DbPadi> personUtilsList;

    RequestQueue rq;

    String request_url = "http://192.168.0.193:5000/padi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagepadi);
        rq = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        sendRequest();

        Toolbar toolbar     =   findViewById(R.id.toolbarpadi);
        setSupportActionBar(toolbar);
        /**
         *  Akan membuat action back ke parent atau ke halaman sebelumnya
         * */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    DbPadi personUtils = new DbPadi();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        personUtils.setId(Integer.valueOf((jsonObject.getString("id"))));
                        personUtils.setLuas_lahan(Integer.valueOf(jsonObject.getString("luas_lahan")));
                        personUtils.setTgl_tanam(jsonObject.getString("tgl_tanam"));
                        personUtils.setTgl_siap_panen(jsonObject.getString("tgl_siap_panen"));
                        personUtils.setHasil_panen(jsonObject.getString("hasil_panen"));
                        personUtils.setPemilik(jsonObject.getString("pemilik"));
                        personUtils.setNik(Integer.valueOf(jsonObject.getString("nik")));
                        personUtils.setPekerja(Integer.valueOf(jsonObject.getString("pekerja")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    personUtilsList.add(personUtils);

                }

                mAdapter = new MyAdapterPadi(personUtilsList);

                recyclerView.setAdapter(mAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", String.valueOf(error));
            }
        });

        rq.add(jsonArrayRequest);

    }

    public void addNewItem(View view) {
        /**
         *  Tujuan perpindahan halaman
         * */
        Intent intent = new Intent(this,InsertActivity.class);
        /**
         *  Akan mengirimkan Tambahan data yang akan di terima berdasarkan Namenya
         * */
        intent.putExtra("create",true);
        startActivity(intent);
    }

}
