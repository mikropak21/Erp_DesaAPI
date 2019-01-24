package com.example.win10.bahanpercobaan2.Function;

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
        View view= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final ViewHolder item=(ViewHolder) viewHolder;
        final Padi padi=list.get(i);

        item.getPemilik().setText(padi.getPemilik());

        Log.e("name",padi.getPemilik());

        item.getLuas().setText(Integer.toString(padi.getLuaslahan()));

        Log.e("address", String.valueOf(padi.getLuaslahan()));

        /*((ViewHolder) viewHolder).relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"You Clicked "+padi.getPemilik(),Toast.LENGTH_LONG).show();
            }
        });*/
    }


    @Override
    public int getItemCount() {

        return list.size();
    }

}