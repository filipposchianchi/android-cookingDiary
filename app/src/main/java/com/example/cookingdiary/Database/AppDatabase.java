package com.example.cookingdiary.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.cookingdiary.Converters;
import com.example.cookingdiary.Ricetta;

@TypeConverters({Converters.class})
@Database(entities = {Ricetta.class}, version=1)
public abstract  class AppDatabase extends RoomDatabase {

    public abstract RicettaDAO ricettaDAO();
}
