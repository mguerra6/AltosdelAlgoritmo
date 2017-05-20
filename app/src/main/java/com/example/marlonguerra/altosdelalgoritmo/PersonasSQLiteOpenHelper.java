package com.example.marlonguerra.altosdelalgoritmo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Marlon guerra on 20/05/2017.
 */

public class PersonasSQLiteOpenHelper extends SQLiteOpenHelper {

    private String sql = "CREATE TABLE Apartamentos(nomenclatura text, metroscuadrados text, precio text, piso text, balcon text, sombra text)";


    public PersonasSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory,version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Apartamentos");
        db.execSQL(sql);
    }
}
