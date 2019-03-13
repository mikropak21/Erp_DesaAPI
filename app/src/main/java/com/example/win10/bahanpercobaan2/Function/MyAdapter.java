package com.example.win10.bahanpercobaan2.Function;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.win10.bahanpercobaan2.DetailPemilik;
import com.example.win10.bahanpercobaan2.EditDataPadi.EditActivity;
import com.example.win10.bahanpercobaan2.R;
import com.example.win10.bahanpercobaan2.TableDb.Padi;
import com.example.win10.bahanpercobaan2.TambahDataActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Padi> personUtils;
    private Context context;

    public MyAdapter(List personUtils) {
        this.personUtils = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.pName.setText(pu.getPersonFirstName());
//        holder.pJobProfile.setText(pu.getJobProfile());
        holder.mTextViewId.setText("" + personUtils.get(position).getId());
        holder.mTextLuasLahan.setText("" + personUtils.get(position).getLuas_lahan());
        holder.mTextTglTanam.setText("" + personUtils.get(position).getTgl_tanam());
        holder.mTextTglPanen.setText("" + personUtils.get(position).getTgl_siap_panen());
        holder.mTextHasilPanen.setText("" + personUtils.get(position).getHasil_panen());
        holder.mTextPemilik.setText("" + personUtils.get(position).getPemilik());
        holder.mTextNik.setText("" + personUtils.get(position).getNik());
        holder.mTextPekerja.setText("" + personUtils.get(position).getPekerja());

    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewId, mTextLuasLahan, mTextTglTanam, mTextTglPanen, mTextHasilPanen, mTextPemilik, mTextNik, mTextPekerja;


        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.item_id);
            mTextLuasLahan = (TextView) itemView.findViewById(R.id.item_address);
            mTextTglTanam = (TextView) itemView.findViewById(R.id.item_tgltanam);
            mTextTglPanen = (TextView) itemView.findViewById(R.id.item_tglpanen);
            mTextHasilPanen = (TextView) itemView.findViewById(R.id.item_hasilpanen);
            mTextPemilik = (TextView) itemView.findViewById(R.id.item_name);
            mTextNik = (TextView) itemView.findViewById(R.id.item_nik);
            mTextPekerja = (TextView) itemView.findViewById(R.id.item_jmlpekerja);
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
                    intent.putExtra("pemilik", mTextPemilik.getText().toString());
                    intent.putExtra("tgl_tanam", mTextTglTanam.getText().toString());
                    intent.putExtra("tgl_panen", mTextTglPanen.getText().toString());
                    intent.putExtra("hasil_panen", mTextHasilPanen.getText().toString());
                    intent.putExtra("luas_lahan", mTextLuasLahan.getText().toString());
                    intent.putExtra("jumlah_pekerja", mTextPekerja.getText().toString());
                    context.startActivity(intent);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    showAlertDialogButtonClicked();
////                    Padi cpu = (Padi) view.getTag();
////
////                    Toast.makeText(view.getContext(), cpu.getPemilik()+" is "+ cpu.getLuas_lahan(), Toast.LENGTH_SHORT).show();
//
                    return false;
                }
//
            });


        }

        private void showAlertDialogButtonClicked() {

            // setup the alert builder
            AlertDialog.Builder alert = new AlertDialog.Builder(context);

            alert.setMessage("Mau kamu apakan datanya?");

            // add the buttons
            alert.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(context,EditActivity.class);
                    /**
                     *  Akan mengirimkan Tambahan data yang akan di terima berdasarkan Namenya
                     * */
                    intent.putExtra("create",true);
                    intent.putExtra("id", mTextViewId.getText().toString());
                    intent.putExtra("luas_lahan", mTextLuasLahan.getText().toString());
                    intent.putExtra("tgl_tanam", mTextTglTanam.getText().toString());
                    intent.putExtra("tgl_siap_panen", mTextTglPanen.getText().toString());
                    intent.putExtra("hasil_panen", mTextHasilPanen.getText().toString());
                    intent.putExtra("pemilik", mTextPemilik.getText().toString());
                    intent.putExtra("nik", mTextNik.getText().toString());
                    intent.putExtra("pekerja", mTextPekerja.getText().toString());
                    context.startActivity(intent);
                }
            });

            alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(context,TambahDataActivity.class);
                    /**
                     *  Akan mengirimkan Tambahan data yang akan di terima berdasarkan Namenya
                     * */
                    intent.putExtra("pemilik", mTextPemilik.getText().toString());
                    intent.putExtra("create",true);
                    context.startActivity(intent);
                }
            });

            // create and show the alert dialog
            AlertDialog dialog = alert.create();
            dialog.show();
        }
    }
//    private void proceedtoUpdate(View v) {
//        Context context = v.getContext();
//        Intent intent = new Intent(context,TambahDataActivity.class);
//        /**
//         *  Akan mengirimkan Tambahan data yang akan di terima berdasarkan Namenya
//         * */
//        intent.putExtra("create",true);
//        startActivity(intent);
//    }
        }