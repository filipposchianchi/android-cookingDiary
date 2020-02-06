package com.example.cookingdiary;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cookingdiary.Database.AppDatabase;

import java.io.ByteArrayOutputStream;

import java.util.ArrayList;
import java.util.Arrays;


public class AddActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private EditText titoloText, ingredientiText1, ingredientiText2, ingredientiText3, ingredientiText4, ingredientiText5,
            ingredientiText6, ingredientiText7, ingredientiText8, ingredientiText9, ingredientiText10, grammiText1,
            grammiText2, grammiText3, grammiText4, grammiText5, grammiText6, grammiText7, grammiText8, grammiText9,
            grammiText10, preparazioneText, numeroPersoneText, calorieText, paroleChiaveText;
    private Button loadImageButton;
    private ImageButton button1, button2, button3, button4, button5, button6, button7, button8, button9, delete1, delete2, delete3;
    private LinearLayout linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8,
            linearLayout9, linearLayout10;
    private ImageView imageView1, imageView2, imageView3;
    private int n = 0;
    private int countIngredienti = 1;
    private boolean almenoUno = false;
    private AppDatabase db;
    private Uri uri1, uri2, uri3;
    public static final int KITKAT_VALUE = 1002;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1 = findViewById(R.id.addButton1);
        button2 = findViewById(R.id.addButton2);
        button3 = findViewById(R.id.addButton3);
        button4 = findViewById(R.id.addButton4);
        button5 = findViewById(R.id.addButton5);
        button6 = findViewById(R.id.addButton6);
        button7 = findViewById(R.id.addButton7);
        button8 = findViewById(R.id.addButton8);
        button9 = findViewById(R.id.addButton9);

        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);
        linearLayout5 = findViewById(R.id.linearLayout5);
        linearLayout6 = findViewById(R.id.linearLayout6);
        linearLayout7 = findViewById(R.id.linearLayout7);
        linearLayout8 = findViewById(R.id.linearLayout8);
        linearLayout9 = findViewById(R.id.linearLayout9);
        linearLayout10 = findViewById(R.id.linearLayout10);

        loadImageButton = findViewById(R.id.loadImageButton);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        titoloText = findViewById(R.id.titoloText);

        ingredientiText1 = findViewById(R.id.ingredientiText1);
        ingredientiText2 = findViewById(R.id.ingredientiText2);
        ingredientiText3 = findViewById(R.id.ingredientiText3);
        ingredientiText4 = findViewById(R.id.ingredientiText4);
        ingredientiText5 = findViewById(R.id.ingredientiText5);
        ingredientiText6 = findViewById(R.id.ingredientiText6);
        ingredientiText7 = findViewById(R.id.ingredientiText7);
        ingredientiText8 = findViewById(R.id.ingredientiText8);
        ingredientiText9 = findViewById(R.id.ingredientiText9);
        ingredientiText10 = findViewById(R.id.ingredientiText10);

        grammiText1 = findViewById(R.id.grammiText1);
        grammiText2 = findViewById(R.id.grammiText2);
        grammiText3 = findViewById(R.id.grammiText3);
        grammiText4 = findViewById(R.id.grammiText4);
        grammiText5 = findViewById(R.id.grammiText5);
        grammiText6 = findViewById(R.id.grammiText6);
        grammiText7 = findViewById(R.id.grammiText7);
        grammiText8 = findViewById(R.id.grammiText8);
        grammiText9 = findViewById(R.id.grammiText9);
        grammiText10 = findViewById(R.id.grammiText10);

        numeroPersoneText = findViewById(R.id.numeroPersoneText);

        calorieText = findViewById(R.id.calorieText);

        preparazioneText = findViewById(R.id.preparazioneText);

        delete1 = findViewById(R.id.deleteButton1);
        delete2 = findViewById(R.id.deleteButton2);
        delete3 = findViewById(R.id.deleteButton3);

        paroleChiaveText = findViewById(R.id.paroleChiaveText);

        db = Room.databaseBuilder(this, AppDatabase.class, "ricette_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();


        loadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n < 3) {
                    Intent intent;
                    if (Build.VERSION.SDK_INT < 19) {
                        intent = new Intent();
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        intent.setType("*/*");
                        startActivityForResult(intent, KITKAT_VALUE);
                    } else {
                        intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType("*/*");
                        startActivityForResult(intent, KITKAT_VALUE);
                    }
                } else
                    Toast.makeText(AddActivity.this, "Hai già caricato 3 immagini", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onAdd1(View v) {
        countIngredienti = 2;
        linearLayout2.setVisibility(View.VISIBLE);
        button1.setVisibility(View.GONE);

    }

    public void onAdd2(View v) {
        countIngredienti = 3;
        linearLayout3.setVisibility(View.VISIBLE);
        button2.setVisibility(View.GONE);
    }

    public void onAdd3(View v) {
        countIngredienti = 4;
        linearLayout4.setVisibility(View.VISIBLE);
        button3.setVisibility(View.GONE);
    }

    public void onAdd4(View v) {
        countIngredienti = 5;
        linearLayout5.setVisibility(View.VISIBLE);
        button4.setVisibility(View.GONE);
    }

    public void onAdd5(View v) {
        countIngredienti = 6;
        linearLayout6.setVisibility(View.VISIBLE);
        button5.setVisibility(View.GONE);
    }

    public void onAdd6(View v) {
        countIngredienti = 7;
        linearLayout7.setVisibility(View.VISIBLE);
        button6.setVisibility(View.GONE);
    }

    public void onAdd7(View v) {
        countIngredienti = 8;
        linearLayout8.setVisibility(View.VISIBLE);
        button7.setVisibility(View.GONE);
    }

    public void onAdd8(View v) {
        countIngredienti = 9;
        linearLayout9.setVisibility(View.VISIBLE);
        button8.setVisibility(View.GONE);
    }

    public void onAdd9(View v) {
        countIngredienti = 10;
        linearLayout10.setVisibility(View.VISIBLE);
        button9.setVisibility(View.GONE);
    }

    public void onDeleteButton1(View view) {
        if (imageView2.getVisibility()==View.VISIBLE) {
            uri1 = uri2;
            imageView1.setImageDrawable(imageView2.getDrawable());
            n=1;
            if (imageView3.getVisibility() == View.VISIBLE) {
               uri2=uri3;
               imageView2.setImageDrawable(imageView3.getDrawable());
               uri3= null;
               imageView3.setVisibility(View.GONE);
               delete3.setVisibility(View.GONE);
               n=2;
            } else {
                imageView2.setImageDrawable(null);
                imageView2.setVisibility(View.GONE);
                delete2.setVisibility(View.GONE);
            }
        } else if (imageView3.getVisibility() == View.VISIBLE) {
            uri1 = uri3;
            imageView1.setImageDrawable(imageView3.getDrawable());
            uri3 = null;
            imageView3.setVisibility(View.GONE);
            delete3.setVisibility(View.GONE);
            n=1;
        } else {
            uri1=null;
            imageView1.setVisibility(View.GONE);
            delete1.setVisibility(View.GONE);
            n=0;
        }
    }

    public void onDeleteButton2(View view) {
        if (imageView3.getVisibility()== View.VISIBLE) {
            uri2=uri3;
            imageView2.setImageDrawable(imageView3.getDrawable());
            uri3 = null;
            imageView3.setVisibility(View.GONE);
            delete3.setVisibility(View.GONE);
            n=2;
        } else {
            uri2 = null;
            imageView2.setVisibility(View.GONE);
            delete2.setVisibility(View.GONE);
            n=1;
        }

    }

    public void onDeleteButton3(View view) {
        uri3 = null;
        imageView3.setVisibility(View.GONE);
        delete3.setVisibility(View.GONE);
        n=2;
    }


    public static Intent getIntentAdd(Context context) {
        Intent intent = new Intent(context, AddActivity.class);
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                break;
            case R.id.app_bar_done:
                String titolo = titoloText.getText().toString().trim();
                ArrayList<String> ingredienti = new ArrayList<>();
                ArrayList<String> grammi = new ArrayList<>();
                switch (countIngredienti) {
                    case (1):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        break;
                    case (2):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        break;
                    case (3):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        break;
                    case (4):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        ingredienti.add(ingredientiText4.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        grammi.add(grammiText4.getText().toString().trim());
                        break;
                    case (5):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        ingredienti.add(ingredientiText4.getText().toString().trim());
                        ingredienti.add(ingredientiText5.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        grammi.add(grammiText4.getText().toString().trim());
                        grammi.add(grammiText5.getText().toString().trim());
                        break;
                    case (6):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        ingredienti.add(ingredientiText4.getText().toString().trim());
                        ingredienti.add(ingredientiText5.getText().toString().trim());
                        ingredienti.add(ingredientiText6.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        grammi.add(grammiText4.getText().toString().trim());
                        grammi.add(grammiText5.getText().toString().trim());
                        grammi.add(grammiText6.getText().toString().trim());
                        break;
                    case (7):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        ingredienti.add(ingredientiText4.getText().toString().trim());
                        ingredienti.add(ingredientiText5.getText().toString().trim());
                        ingredienti.add(ingredientiText6.getText().toString().trim());
                        ingredienti.add(ingredientiText7.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        grammi.add(grammiText4.getText().toString().trim());
                        grammi.add(grammiText5.getText().toString().trim());
                        grammi.add(grammiText6.getText().toString().trim());
                        grammi.add(grammiText7.getText().toString().trim());
                        break;
                    case (8):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        ingredienti.add(ingredientiText4.getText().toString().trim());
                        ingredienti.add(ingredientiText5.getText().toString().trim());
                        ingredienti.add(ingredientiText6.getText().toString().trim());
                        ingredienti.add(ingredientiText7.getText().toString().trim());
                        ingredienti.add(ingredientiText8.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        grammi.add(grammiText4.getText().toString().trim());
                        grammi.add(grammiText5.getText().toString().trim());
                        grammi.add(grammiText6.getText().toString().trim());
                        grammi.add(grammiText7.getText().toString().trim());
                        grammi.add(grammiText8.getText().toString().trim());
                        break;
                    case (9):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        ingredienti.add(ingredientiText4.getText().toString().trim());
                        ingredienti.add(ingredientiText5.getText().toString().trim());
                        ingredienti.add(ingredientiText6.getText().toString().trim());
                        ingredienti.add(ingredientiText7.getText().toString().trim());
                        ingredienti.add(ingredientiText8.getText().toString().trim());
                        ingredienti.add(ingredientiText9.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        grammi.add(grammiText4.getText().toString().trim());
                        grammi.add(grammiText5.getText().toString().trim());
                        grammi.add(grammiText6.getText().toString().trim());
                        grammi.add(grammiText7.getText().toString().trim());
                        grammi.add(grammiText8.getText().toString().trim());
                        grammi.add(grammiText9.getText().toString().trim());
                        break;
                    case (10):
                        ingredienti.add(ingredientiText1.getText().toString().trim());
                        ingredienti.add(ingredientiText2.getText().toString().trim());
                        ingredienti.add(ingredientiText3.getText().toString().trim());
                        ingredienti.add(ingredientiText4.getText().toString().trim());
                        ingredienti.add(ingredientiText5.getText().toString().trim());
                        ingredienti.add(ingredientiText6.getText().toString().trim());
                        ingredienti.add(ingredientiText7.getText().toString().trim());
                        ingredienti.add(ingredientiText8.getText().toString().trim());
                        ingredienti.add(ingredientiText9.getText().toString().trim());
                        ingredienti.add(ingredientiText10.getText().toString().trim());
                        grammi.add(grammiText1.getText().toString().trim());
                        grammi.add(grammiText2.getText().toString().trim());
                        grammi.add(grammiText3.getText().toString().trim());
                        grammi.add(grammiText4.getText().toString().trim());
                        grammi.add(grammiText5.getText().toString().trim());
                        grammi.add(grammiText6.getText().toString().trim());
                        grammi.add(grammiText7.getText().toString().trim());
                        grammi.add(grammiText8.getText().toString().trim());
                        grammi.add(grammiText9.getText().toString().trim());
                        grammi.add(grammiText10.getText().toString().trim());
                        break;
                }

                String preparazione = preparazioneText.getText().toString();
                String numeroPersone = numeroPersoneText.getText().toString().trim();
                String calorie = calorieText.getText().toString().trim();
                String paroleChiave = paroleChiaveText.getText().toString().replace( " ", ", ");


                if (!titolo.isEmpty() && !ingredienti.get(countIngredienti - 1).isEmpty() &&
                        !grammi.get(countIngredienti - 1).isEmpty() && !preparazione.isEmpty() && !numeroPersone.isEmpty()) {
                    if (n==0)
                        Toast.makeText(this, "Devi caricare almeno un'immagine", Toast.LENGTH_SHORT).show();
                    else if (n==1) {
                        String path1 = uri1.toString();
                        db.ricettaDAO().insertAll(new Ricetta(titolo, ingredienti, grammi, numeroPersone, calorie, preparazione,
                                path1,paroleChiave));
                        MainActivity.aggiornaLista();
                        finish();
                    } else if (n==2) {
                        String path1 = uri1.toString();
                        String path2 = uri2.toString();
                        db.ricettaDAO().insertAll(new Ricetta(titolo, ingredienti, grammi, numeroPersone, calorie, preparazione,
                                path1, path2,paroleChiave));
                        MainActivity.aggiornaLista();
                        finish();
                    } else {
                        String path1 = uri1.toString();
                        String path2 = uri2.toString();
                        String path3 = uri3.toString();
                        db.ricettaDAO().insertAll(new Ricetta(titolo, ingredienti, grammi, numeroPersone, calorie, preparazione,
                                path1, path2, path3,paroleChiave));
                        MainActivity.aggiornaLista();
                        finish();
                    }
                } else
                    Toast.makeText(this, "Campi mancanti", Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //scelgo la/le immagine/e e la/e mostro
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == KITKAT_VALUE) {
            if (resultCode == Activity.RESULT_OK) {
                if (n == 0) {
                    uri1 = data.getData();
                    Glide.with(AddActivity.this).load(uri1)
                            .into(imageView1);
                    imageView1.setVisibility(View.VISIBLE);
                    delete1.setVisibility(View.VISIBLE);
                    almenoUno = true;
                    if (imageView2.getVisibility() == View.GONE && imageView3.getVisibility() == View.GONE)
                        n = 1;
                    else if (imageView2.getVisibility() == View.VISIBLE && imageView3.getVisibility() == View.VISIBLE)
                        n = 3;
                    else if (imageView2.getVisibility() == View.VISIBLE && imageView3.getVisibility() == View.GONE)
                        n = 2;
                    else if (imageView2.getVisibility() == View.GONE && imageView3.getVisibility() == View.VISIBLE)
                        n = 1;
                } else if (n == 1) {
                    uri2 = data.getData();
                    Glide.with(AddActivity.this).load(uri2)
                            .into(imageView2);
                    imageView2.setVisibility(View.VISIBLE);
                    delete2.setVisibility(View.VISIBLE);
                    n = 2;
                    almenoUno = true;
                    if (imageView1.getVisibility() == View.GONE)
                        n = 0;
                    else if (imageView1.getVisibility() == View.VISIBLE && imageView3.getVisibility() == View.GONE)
                        n = 2;
                    else if (imageView1.getVisibility() == View.VISIBLE && imageView3.getVisibility() == View.VISIBLE)
                        n = 3;
                } else {
                    uri3 = data.getData();
                    Glide.with(AddActivity.this).load(uri3)
                            .into(imageView3);
                    imageView3.setVisibility(View.VISIBLE);
                    delete3.setVisibility(View.VISIBLE);
                    almenoUno = true;
                    if (imageView1.getVisibility() == View.GONE)
                        n = 0;
                    else if (imageView1.getVisibility() == View.VISIBLE && imageView2.getVisibility() == View.GONE)
                        n = 1;
                    else if (imageView1.getVisibility() == View.VISIBLE && imageView2.getVisibility() == View.VISIBLE)
                        n = 3;
                }
            }
        }
    }


}
