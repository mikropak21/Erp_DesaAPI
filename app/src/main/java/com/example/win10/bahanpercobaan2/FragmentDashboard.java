package com.example.win10.bahanpercobaan2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.EventLogTags;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.win10.bahanpercobaan2.MyGreenDao.AppController;
import com.example.win10.bahanpercobaan2.TableDb.Padi;
import com.example.win10.bahanpercobaan2.TableDb.PadiDao;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class FragmentDashboard extends Fragment {
    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sidebardashboard, container, false);
        BarChart barChart = (BarChart) view.findViewById(R.id.chart);

       /* Padi padi   =   new Padi();
        int luas    =  padi.getLuaslahan();*/


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(15.5f, 0));
        entries.add(new BarEntry(10.8f, 1));
        entries.add(new BarEntry(11.6f, 2));
        entries.add(new BarEntry(7f, 3));
        entries.add(new BarEntry(9.6f, 4));
        entries.add(new BarEntry(6.1f, 5));
        entries.add(new BarEntry(6.23f, 6));

        BarDataSet dataset = new BarDataSet(entries, "");
        dataset.setBarSpacePercent(50f);

        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");

        BarData data2 = new BarData(labels, dataset);
        dataset.setColors(new int[]
                {
                Color.parseColor("#4dab53"),
                Color.parseColor("#e8e63a"),
                Color.parseColor("#76bf43"),
                Color.parseColor("#4e9844"),
                Color.parseColor("#9a7c2d"),
                Color.parseColor("#d3d22d"),
                Color.parseColor("#d09a2d")
                });
        barChart.setData(data2);
        barChart.invalidate(); // refresh

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelsToSkip(0);

        YAxis yAxis = barChart.getAxisLeft();
        yAxis.setAxisMaxValue(16f);
        yAxis.setAxisMinValue(2f);
        yAxis.setTextColor(Color.parseColor("#6a6a6a"));
        yAxis.setGranularity(0.5f);
        yAxis.setTextSize(12f);
        yAxis.setAxisLineColor(Color.parseColor("#c5c3c3"));
        yAxis.setLabelCount(8,true);
        //

        barChart.setDragEnabled(true);
        barChart.setVisibility(3);
        barChart.setDescription("");
        barChart.getLegend().setEnabled(false);
        barChart.setDrawValueAboveBar(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.setDrawValueAboveBar(true);
        barChart.animateY(5000);

        return view;
    }

}
