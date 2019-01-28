package com.example.win10.bahanpercobaan2.Function;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.win10.bahanpercobaan2.DetailPemilik;
import com.example.win10.bahanpercobaan2.R;
import com.example.win10.bahanpercobaan2.TableDb.Padi;

import java.io.Serializable;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView pemilik,luas,tgl_tanam,tgl_panen,hasil_panen,jumlah_pekerja;
    private RelativeLayout relativeLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        pemilik         =   itemView.findViewById(R.id.item_name);
        luas            =   itemView.findViewById(R.id.item_address);
        tgl_tanam       =   itemView.findViewById(R.id.item_tgltanam);
        tgl_panen       =   itemView.findViewById(R.id.item_tglpanen);
        hasil_panen     =   itemView.findViewById(R.id.item_hasilpanen);
        jumlah_pekerja  =   itemView.findViewById(R.id.item_jmlpekerja);
        relativeLayout  =   itemView.findViewById(R.id.itemlist);
        /**
         *  Function onclick tiap item recyclerView
         * */
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                /**
                 *  Perpindahan halaman ke DetailPemilik setelah item di click
                 * */
                Intent intent = new Intent(context, DetailPemilik.class);
                /**
                 *  Dalam proses perpindahan halaman, saat kita onclick maka akan mengirimkan Name
                 *  ATAU Key yang akan di terima di halaman yang dituju
                 * */
                intent.putExtra("pemilik",pemilik.getText().toString());
                intent.putExtra("tgl_tanam",tgl_tanam.getText().toString());
                intent.putExtra("tgl_panen",tgl_panen.getText().toString());
                intent.putExtra("hasil_panen",hasil_panen.getText().toString());
                intent.putExtra("luas_lahan",luas.getText().toString());
                intent.putExtra("jumlah_pekerja",jumlah_pekerja.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    public TextView getPemilik() {
        return pemilik;
    }

    public TextView getLuas(){
        return luas;
    }

    public TextView getTgl_tanam(){
        return tgl_tanam;
    }

    public TextView getTgl_panen(){
        return tgl_panen;
    }

    public TextView getHasil_panen(){
        return hasil_panen;
    }

    public TextView getJumlah_pekerja()
    {
        return jumlah_pekerja;
    }

    public RelativeLayout getRelativeLayout()
    {
        return relativeLayout;
    }
}

