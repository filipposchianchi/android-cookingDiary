package com.example.cookingdiary;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cookingdiary.Database.AppDatabase;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;



public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = DetailsActivity.class.getName();
    private static final String KEY = TAG + ".key";
    private AppDatabase db;
    private TextView ingrediente1Details,ingrediente2Details,ingrediente3Details,ingrediente4Details,ingrediente5Details,ingrediente6Details,
                ingrediente7Details,ingrediente8Details,ingrediente9Details,ingrediente10Details, grammi1Details,grammi2Details,
            grammi3Details,grammi4Details,grammi5Details,grammi6Details,grammi7Details,grammi8Details,grammi9Details,grammi10Details,
                grammi1, grammi2,grammi3,grammi4,grammi5,grammi6,grammi7,grammi8,grammi9,grammi10,numeroPersoneDetails, preparazioneDetails,
             calorie, parolaChiaveDetails;
    private CardView cardViewCal;
    private InputStream correctUri1, correctUri2, correctUri3;
    private Ricetta ricetta;
    private ViewPager viewPager;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ingrediente1Details = findViewById(R.id.ingrediente1details);
        ingrediente2Details = findViewById(R.id.ingrediente2details);
        ingrediente3Details = findViewById(R.id.ingrediente3details);
        ingrediente4Details = findViewById(R.id.ingrediente4details);
        ingrediente5Details = findViewById(R.id.ingrediente5details);
        ingrediente6Details = findViewById(R.id.ingrediente6details);
        ingrediente7Details = findViewById(R.id.ingrediente7details);
        ingrediente8Details = findViewById(R.id.ingrediente8details);
        ingrediente9Details = findViewById(R.id.ingrediente9details);
        ingrediente10Details = findViewById(R.id.ingrediente10details);

        grammi1Details = findViewById(R.id.grammi1details);
        grammi2Details = findViewById(R.id.grammi2details);
        grammi3Details = findViewById(R.id.grammi3details);
        grammi4Details = findViewById(R.id.grammi4details);
        grammi5Details = findViewById(R.id.grammi5details);
        grammi6Details = findViewById(R.id.grammi6details);
        grammi7Details = findViewById(R.id.grammi7details);
        grammi8Details = findViewById(R.id.grammi8details);
        grammi9Details = findViewById(R.id.grammi9details);
        grammi10Details = findViewById(R.id.grammi10details);

        grammi1 = findViewById(R.id.grammi1);
        grammi2 = findViewById(R.id.grammi2);
        grammi3 = findViewById(R.id.grammi3);
        grammi4 = findViewById(R.id.grammi4);
        grammi5 = findViewById(R.id.grammi5);
        grammi6 = findViewById(R.id.grammi6);
        grammi7 = findViewById(R.id.grammi7);
        grammi8 = findViewById(R.id.grammi8);
        grammi9 = findViewById(R.id.grammi9);
        grammi10 = findViewById(R.id.grammi10);

        numeroPersoneDetails = findViewById(R.id.numeroPersoneDetails);

        cardViewCal = findViewById(R.id.cardViewCal);
        calorie = findViewById(R.id.calorie);


        preparazioneDetails = findViewById(R.id.preparazioneDetails);

        viewPager = findViewById(R.id.viewPager);

        parolaChiaveDetails = findViewById(R.id.paroleChiaveDetails);

        db = Room.databaseBuilder(DetailsActivity.this, AppDatabase.class, "ricette_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        ricetta = (Ricetta) getIntent().getSerializableExtra(KEY);

        int nIngredienti = ricetta.getIngredienti().size();
        int c=0;

        toolbar.setTitle(ricetta.getTitolo());
        ingrediente1Details.setText(ricetta.getIngredienti().get(c));
        grammi1Details.setText(ricetta.getGrammi().get(c));
        c++;

        if (nIngredienti>c) {
            ingrediente2Details.setText(ricetta.getIngredienti().get(c));
            grammi2Details.setText(ricetta.getGrammi().get(c));
            ingrediente2Details.setVisibility(View.VISIBLE);
            grammi2Details.setVisibility(View.VISIBLE);
            grammi2.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente3Details.setText(ricetta.getIngredienti().get(c));
            grammi3Details.setText(ricetta.getGrammi().get(c));
            ingrediente3Details.setVisibility(View.VISIBLE);
            grammi3Details.setVisibility(View.VISIBLE);
            grammi3.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente4Details.setText(ricetta.getIngredienti().get(c));
            grammi4Details.setText(ricetta.getGrammi().get(c));
            ingrediente4Details.setVisibility(View.VISIBLE);
            grammi4Details.setVisibility(View.VISIBLE);
            grammi4.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente5Details.setText(ricetta.getIngredienti().get(c));
            grammi5Details.setText(ricetta.getGrammi().get(c));
            ingrediente5Details.setVisibility(View.VISIBLE);
            grammi5Details.setVisibility(View.VISIBLE);
            grammi5.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente6Details.setText(ricetta.getIngredienti().get(c));
            grammi6Details.setText(ricetta.getGrammi().get(c));
            ingrediente6Details.setVisibility(View.VISIBLE);
            grammi6Details.setVisibility(View.VISIBLE);
            grammi6.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente7Details.setText(ricetta.getIngredienti().get(c));
            grammi7Details.setText(ricetta.getGrammi().get(c));
            ingrediente7Details.setVisibility(View.VISIBLE);
            grammi7Details.setVisibility(View.VISIBLE);
            grammi7.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente8Details.setText(ricetta.getIngredienti().get(c));
            grammi8Details.setText(ricetta.getGrammi().get(c));
            ingrediente8Details.setVisibility(View.VISIBLE);
            grammi8Details.setVisibility(View.VISIBLE);
            grammi8.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente9Details.setText(ricetta.getIngredienti().get(c));
            grammi9Details.setText(ricetta.getGrammi().get(c));
            ingrediente9Details.setVisibility(View.VISIBLE);
            grammi9Details.setVisibility(View.VISIBLE);
            grammi9.setVisibility(View.VISIBLE);
            c++;
        }
        if(nIngredienti>c) {
            ingrediente10Details.setText(ricetta.getIngredienti().get(c));
            grammi10Details.setText(ricetta.getGrammi().get(c));
            ingrediente10Details.setVisibility(View.VISIBLE);
            grammi10Details.setVisibility(View.VISIBLE);
            grammi10.setVisibility(View.VISIBLE);
        }

        numeroPersoneDetails.setText(ricetta.getNumeroPersone());

        if (ricetta.getCalorie().isEmpty()) {
            cardViewCal.setVisibility(View.GONE);
        } else {
            calorie.setText(ricetta.getCalorie());
        }

        preparazioneDetails.setText(ricetta.getPreparazione());



        //decrease memory used
       /* BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 3;*/


        ArrayList<String> inputStreams = new ArrayList<String>();

        //try {
            if (ricetta.getImage1() != null) {
                //correctUri1 = getContentResolver().openInputStream(Uri.parse(ricetta.getImage1()));
                //Bitmap bmp1 = BitmapFactory.decodeStream(correctUri1);
                //Bitmap bmp1 = BitmapFactory.decodeStream(correctUri1,null, options);

                inputStreams.add(ricetta.getImage1());
                /*Glide.with(this)
                        .asBitmap()
                        .load(bmp1)
                        .into(immagineRicetta1);*/
                if (ricetta.getImage2()!= null) {
                    //correctUri2 = getContentResolver().openInputStream(Uri.parse(ricetta.getImage2()));
                    //Bitmap bmp2 = BitmapFactory.decodeStream(correctUri2);
                    //Bitmap bmp2 = BitmapFactory.decodeStream(correctUri2,null, options);
                    inputStreams.add(ricetta.getImage2());
                    if (ricetta.getImage3()!= null){
                       //correctUri3 = getContentResolver().openInputStream(Uri.parse(ricetta.getImage3()));
                        //Bitmap bmp3 = BitmapFactory.decodeStream(correctUri3);
                        //Bitmap bmp3 = BitmapFactory.decodeStream(correctUri3,null, options);
                        inputStreams.add(ricetta.getImage3());
                    }
                }
            }
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}

        parolaChiaveDetails.setText(ricetta.getParoleChiave());

        adapter = new ImageAdapter(this, inputStreams);
        viewPager.setAdapter(adapter);

    }


    public static Intent getIntentDetails(Context context, Ricetta ricetta) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY, ricetta);
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                break;
            case R.id.app_bar_delete:
                showAlertView("Conferma Cancellazione", "Vuoi davvero cancellare la tua ricetta?");

        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertView(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.ricettaDAO().delete(ricetta);
                MainActivity.aggiornaLista();
                finish();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
