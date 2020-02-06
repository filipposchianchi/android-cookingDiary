package com.example.cookingdiary.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.cookingdiary.Ricetta;

import java.util.List;

@Dao
public interface RicettaDAO {

    @Query("SELECT * FROM  ricetta")
    List<Ricetta> getAl();


    @Insert
    void insertAll(Ricetta... ricettas);

    @Delete
    void delete(Ricetta ricetta);
}
