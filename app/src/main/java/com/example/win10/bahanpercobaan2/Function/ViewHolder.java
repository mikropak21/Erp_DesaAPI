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

import java.io.Serializable;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView pemilik,tgl_tanam;
    RelativeLayout relativeLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        pemilik=itemView.findViewById(R.id.item_name);
        tgl_tanam = itemView.findViewById(R.id.item_address);
        relativeLayout  =   itemView.findViewById(R.id.itemlist);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailPemilik.class);
                intent.putExtra("pemilik",pemilik.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    public TextView getPemilik() {
        return pemilik;
    }

    public TextView getTgl_tanam(){
        return tgl_tanam;
    }

    public RelativeLayout getRelativeLayout()
    {
        return relativeLayout;
    }
}

