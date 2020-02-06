package com.example.cookingdiary;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import com.example.cookingdiary.Database.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static AppDatabase db;
    private static List<Ricetta> ricettas;
    private static RecyclerView recyclerView;
    private static RecyclerViewAdapter adapter;
    private static Context baseContext;
    private static View viewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewLayout = findViewById(R.id.viewLayout);
        baseContext = MainActivity.this;

        if (savedInstanceState == null) {
            db = Room.databaseBuilder(MainActivity.this, AppDatabase.class, "ricette_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
            getValue();
        }

        recyclerView =findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(ricettas, MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddActivity.getIntentAdd(MainActivity.this));
            }
        });

    }

    private static void getValue() {
        ricettas = db.ricettaDAO().getAl();

        recyclerView = viewLayout.findViewById(R.id.recyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(ricettas,baseContext);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    public static void aggiornaLista(){
        getValue();

    }


    public static void sendObject(Context context, int i) {
        context.startActivity(DetailsActivity.getIntentDetails(context, ricettas.get(i)));
    }
}
