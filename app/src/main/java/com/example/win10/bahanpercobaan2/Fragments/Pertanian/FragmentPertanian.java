package com.example.win10.bahanpercobaan2.Fragments.Pertanian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.win10.bahanpercobaan2.CrudPadi.Insert.InsertActivity;
import com.example.win10.bahanpercobaan2.Fragments.Pertanian.InsideFragment.Pertanian_Detailpadi;
import com.example.win10.bahanpercobaan2.R;

public class FragmentPertanian extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagepertanian, container, false);

        RelativeLayout btnopen  =   (RelativeLayout) view.findViewById(R.id.onclickpad);
        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =   new Intent(getActivity(), Pertanian_Detailpadi.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabsideper);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambah = new Intent(getActivity(), InsertActivity.class);
                tambah.putExtra("create",true);
                startActivity(tambah);
            }
        });
        return view;

    }
}
