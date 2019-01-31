package com.example.win10.bahanpercobaan2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DashboardGraph extends AppCompatActivity {

    View view;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sidebardashboard);



    }

    // Mengatur Button Warna setelah di pencet (On Click)
    public void birutua(View view){
        view.setBackgroundResource(R.color.bagtoolbar);
    }
}
