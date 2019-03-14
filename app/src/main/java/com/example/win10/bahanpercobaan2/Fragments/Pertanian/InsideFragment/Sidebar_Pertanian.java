package com.example.win10.bahanpercobaan2.Fragments.Pertanian.InsideFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.win10.bahanpercobaan2.R;

public class Sidebar_Pertanian extends AppCompatActivity {
    // Buat value button
    private RelativeLayout padi;

    /*ListView listView;
    List<DbPadi> groceries = new ArrayList<>();

    DaoSession daoSession;
    ArrayAdapter<DbPadi> groceryArrayAdapter;*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagepertanian);

        /*listView = (ListView) findViewById(R.id.list_view);

        daoSession = ((AppController) getApplication()).getDaoSession();*/

        /*setupListView();*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Value button yang berisi ID  =   button2
        padi =(RelativeLayout) findViewById(R.id.onclickpad);

        padi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpagepadi();
            }

        });


    }


    public void openpagepadi() {
        Intent open = new Intent(this, Pertanian_Detailpadi.class);
        startActivity(open);
    }

    /*@Override
    protected void onResume() {
        super.onResume();

        fetchGroceryList();
    }*/


    /*private void setupListView() {
        groceryArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,groceries);
        listView.setAdapter(groceryArrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                showOptions(position);

                return false;
            }
        });
    }


    private void showOptions(int position) {
        final DbPadi selectedPadiItem = groceries.get(position);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        String[] options = new String[2];

        options[0] = "Edit " + selectedPadiItem.getPemilik();
        options[1] = "Delete " + selectedPadiItem.getPemilik();

        alertDialogBuilder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    proceedToUpdateItem(selectedPadiItem);
                }else if(which == 1){
                    deleteGroceryItem(selectedPadiItem.getId());
                }

                dialog.dismiss();
            }
        });
        alertDialogBuilder.create().show();
    }


    private void fetchGroceryList(){
        groceries.clear();
        // Get the entity dao we need to work with.
        PadiDao groceryDao = daoSession.getPadiDao();

        // Load all items
        groceries.addAll(groceryDao.loadAll());

        // Notify our adapter of changes
        groceryArrayAdapter.notifyDataSetChanged();
    }


    private void deleteGroceryItem(long id){
        // Get the entity dao we need to work with.
        PadiDao groceryDao = daoSession.getPadiDao();
        // perform delete operation
        groceryDao.deleteByKey(id);

        fetchGroceryList();
    }


    private void proceedToUpdateItem(DbPadi grocery){
        // Pass grocery id to the next screen
        Intent intent = new Intent(this,TambahDataActivit.class);
        intent.putExtra("create",false);
        intent.putExtra("padi", (Serializable) grocery);
        startActivity(intent);
    }*/

}
