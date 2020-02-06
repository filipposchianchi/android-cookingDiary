package com.example.cookingdiary;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Ricetta implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title_column")
    private String titolo;

    @ColumnInfo(name = "ingredients_column")
    private ArrayList<String> ingredienti;

    @ColumnInfo(name = "grams_column")
    private ArrayList<String> grammi;

    @ColumnInfo(name = "numberPeople_column")
    private String numeroPersone;

    @ColumnInfo(name = "calories_column")
    private String calorie;

    @ColumnInfo(name = "preparation_column")
    private String preparazione;

    @ColumnInfo(name = "image1_column")
    private String image1;

    @ColumnInfo(name = "image2_column")
    private String image2;

    @ColumnInfo(name = "image3_column")
    private String image3;

    @ColumnInfo(name = "paroleChiave_column")
    private String paroleChiave;


    @Ignore
    public Ricetta(String titolo, ArrayList<String> ingredienti, ArrayList<String> grammi, String numeroPersone, String calorie,
                   String preparazione, String image1,String paroleChiave) {
        this.titolo = titolo;
        this.ingredienti = ingredienti;
        this.grammi = grammi;
        this.numeroPersone = numeroPersone;
        this.calorie = calorie;
        this.preparazione = preparazione;
        this.image1 = image1;
        this.paroleChiave = paroleChiave;
    }

    @Ignore
    public Ricetta(String titolo, ArrayList<String> ingredienti, ArrayList<String> grammi, String numeroPersone, String calorie,
                   String preparazione, String image1, String image2,String paroleChiave) {
        this.titolo = titolo;
        this.ingredienti = ingredienti;
        this.grammi = grammi;
        this.numeroPersone = numeroPersone;
        this.calorie = calorie;
        this.preparazione = preparazione;
        this.image1 = image1;
        this.image2 = image2;
        this.paroleChiave = paroleChiave;
    }

    public Ricetta(String titolo, ArrayList<String> ingredienti, ArrayList<String> grammi, String numeroPersone, String calorie,
                   String preparazione, String image1, String image2, String image3,String paroleChiave) {
        this.titolo = titolo;
        this.ingredienti = ingredienti;
        this.grammi = grammi;
        this.numeroPersone = numeroPersone;
        this.calorie = calorie;
        this.preparazione = preparazione;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.paroleChiave = paroleChiave;
    }


    public String getParoleChiave() {
        return paroleChiave;
    }

    public void setParoleChiave(String paroleChiave) {
        this.paroleChiave = paroleChiave;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(String numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public ArrayList<String> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(ArrayList<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public ArrayList<String> getGrammi() {
        return grammi;
    }

    public void setGrammi(ArrayList<String> grammi) {
        this.grammi = grammi;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getPreparazione() {
        return preparazione;
    }

    public void setPreparazione(String preparazione) {
        this.preparazione = preparazione;
    }


}
