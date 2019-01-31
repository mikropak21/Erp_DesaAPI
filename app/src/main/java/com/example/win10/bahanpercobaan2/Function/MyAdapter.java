package com.example.win10.bahanpercobaan2.Function;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.win10.bahanpercobaan2.DetailPemilik;
import com.example.win10.bahanpercobaan2.R;
import com.example.win10.bahanpercobaan2.TableDb.Padi;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Padi> list;
    Context context;

    public MyAdapter(List<Padi> list, Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /**
         *  Akan menentukan layout yang digunakan nantinya contoh (item)
         * */
        View view= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final ViewHolder item=(ViewHolder) viewHolder;
        final Padi padi=list.get(i);

        /** Nampilin Tampilan Nama Pemilik  */
        item.getPemilik().setText(padi.getPemilik());
        Log.e("name",padi.getPemilik());

        /**  Nampilin Tampilan Luas Lahan   */
        item.getLuas().setText(Integer.toString(padi.getLuaslahan()));
        Log.e("luas_lahan", String.valueOf(padi.getLuaslahan()));

        /** Nampilin Tampilan Tanggal Tanam */
        item.getTgl_tanam().setText(padi.getTgl_tanam());
        Log.e("tgl_tanam",padi.getTgl_tanam());

        /** Nampilin Tampilan Tanggal Panen */
        item.getTgl_panen().setText(padi.getTgl_siappanen());
        Log.e("tgl_panen",padi.getTgl_siappanen());

        /** Nampilin Tampilan Hasil Panen   */
        item.getHasil_panen().setText(padi.getHasilpanen());
        Log.e("hasil_panen",padi.getHasilpanen());

        /** Nampilin Tampilan Jumlah Pekerja */
        item.getJumlah_pekerja().setText(Integer.toString(padi.getJ_pekerja()));
        Log.e("jumlah_pekerja", String.valueOf(padi.getJ_pekerja()));


    }


    @Override
    public int getItemCount() {

        return list.size();
    }

}