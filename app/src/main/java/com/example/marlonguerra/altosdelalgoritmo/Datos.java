package com.example.marlonguerra.altosdelalgoritmo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Marlon guerra on 20/05/2017.
 */

public class Datos {

    public static ArrayList<Apartamento> traerPersonas(Context contexto){
    ArrayList<Apartamento> apartamentos = new ArrayList<>();

    //Declarar variables
    SQLiteDatabase db;
        String sql, nomenclatura, metrocuadrado, precio, piso, balcom, sombra;
    Apartamento p;
    //Abrir conexión de lectura
    PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
    db = aux.getReadableDatabase();

    //Cursor
    sql ="select * from Apartamentos";
    Cursor c = db.rawQuery(sql,null);

    //Recorrido del cursor
    if(c.moveToFirst()){
        do{
            nomenclatura = c.getString(0);
            metrocuadrado = c.getString(1);
            precio =c.getString(2);
            piso = c.getString(3);
            balcom = c.getString(4);
            sombra = c.getString(5);
            p = new Apartamento(nomenclatura,metrocuadrado,precio,piso,balcom,sombra);
            apartamentos.add(p);

        }while (c.moveToNext());
    }

    db.close();

    return apartamentos;

}

    public static Apartamento buscarApartamento(Context contexto, String ced){


        //Declarar variables
        SQLiteDatabase db;
        String sql, nomenclatura, metrocuadrado, precio, piso, balcom, sombra;
        Apartamento p = null;
        //Abrir conexión de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Apartamentos where nomenclatura ='"+ced+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            nomenclatura = c.getString(0);
            metrocuadrado = c.getString(1);
            precio =c.getString(2);
            piso = c.getString(3);
            balcom = c.getString(4);
            sombra = c.getString(5);
            p = new Apartamento(nomenclatura, metrocuadrado, precio, piso, balcom, sombra);
        }

        db.close();
        return p;
    }

//Reporte # 1
    public static int ApartamentosConSombraYBalcon(Context contexto){

        //Declarar variables
        SQLiteDatabase db;
        String sql, nomenclatura, metrocuadrado, precio, piso, balcom, sombra;
        Apartamento p = null;
        //Abrir conexión de lectura
        int cantidad;
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="SELECT * " +
                "FROM Apartamentos " +
                "WHERE balcon = 'Balcon' AND sombra = 'Sombra'";

        Cursor c = db.rawQuery(sql,null);

        cantidad = c.getCount();
        //Recorrido del cursor

        db.close();
        return cantidad;
    }

    //Reporte # 1
    public static int ApartamentosmasCaro(Context contexto){

        //Declarar variables
        SQLiteDatabase db;
        String sql, nomenclatura, metrocuadrado, precio, piso, balcom, sombra;
        Apartamento p = null;
        //Abrir conexión de lectura
        int cantidad;
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="SELECT precio FROM Apartamentos " +
                "ORDER BY precio ASC;";

        Cursor c = db.rawQuery(sql,null);

        cantidad = c.getCount();
        //Recorrido del cursor

        db.close();
        return cantidad;
    }

}

