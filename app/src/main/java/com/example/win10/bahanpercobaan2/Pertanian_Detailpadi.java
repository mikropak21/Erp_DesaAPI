package com.example.win10.bahanpercobaan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.win10.bahanpercobaan2.Function.MyAdapter;
import com.example.win10.bahanpercobaan2.MyGreenDao.AppController;
import com.example.win10.bahanpercobaan2.TableDb.DaoSession;
import com.example.win10.bahanpercobaan2.TableDb.Padi;
import com.example.win10.bahanpercobaan2.TableDb.PadiDao;

import java.util.ArrayList;
import java.util.List;

public class Pertanian_Detailpadi extends AppCompatActivity
{
    /**
     * RecyclerView = menyimpan sebanyak mungkin tampilan item yang muat di layar
     * Dan juga Hanya menggunakan tampilan dalam jumlah terbatas yang digunakan kembali saat tampilan tersebut tidak tampak di layar.
     *
     * Intinya digunakan untuk menyimpan item ke tampilan
     * **/
    RecyclerView listView;
    /**
     * Repository   =   Tempatnya menyimpan Fungsion2 buat database(Table user)
     * */
    DaoSession  daoSession;
    List<Padi> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagepadi);
        listView   = (RecyclerView)   this.findViewById(R.id.listUser);
        list=new ArrayList<>();
        adapter=new MyAdapter(list,this);

        Toolbar toolbar     =   findViewById(R.id.toolbarpadi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        daoSession = ((AppController) getApplication()).getDaoSession();
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setHasFixedSize(true);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(adapter);

    }
    public void bukaPemilik(){

        // Memasukan konten dan fungsion yang berapa pada mainactivity3
        Intent pemilik1 = new Intent(this,DetailPemilik.class);
        startActivity(pemilik1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        fetchGroceryList();
    }



    private void fetchGroceryList(){
        list.clear();
        // Get the entity dao we need to work with.
        PadiDao groceryDao = daoSession.getPadiDao();

        // Load all items
        list.addAll(groceryDao.loadAll());

        // Notify our adapter of changes
        adapter.notifyDataSetChanged();
    }

    public void addNewItem(View view) {
        // Go to add item activity
        Intent intent = new Intent(this,TambahDataActivity.class);
        intent.putExtra("create",true);
        startActivity(intent);
    }
}
