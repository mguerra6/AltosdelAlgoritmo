package com.example.marlonguerra.altosdelalgoritmo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Marlon guerra on 20/05/2017.
 */

public class Datos {

    private static Apartamento a;

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

    //Reporte # 2
    public static ArrayList<Apartamento> ApartamentosmasCaro(Context contexto){

        ArrayList<Apartamento> apartamentos = new ArrayList<>();

        //Declarar variables
        SQLiteDatabase db;
        String sql, nomenclatura, metrocuadrado, precio, piso, balcom, sombra;

        //Abrir conexión de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql = "SELECT * " +
                "FROM Apartamentos  " +
                "ORDER BY precio DESC LIMIT 1 ; ";

        Cursor c = db.rawQuery(sql,null);

        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
                nomenclatura = c.getString(0);
                metrocuadrado = c.getString(1);
                precio = c.getString(2);
                piso = c.getString(3);
                balcom = c.getString(4);
                sombra = c.getString(5);

                a = new Apartamento(nomenclatura, metrocuadrado, precio, piso, balcom, sombra);
                apartamentos.add(a);

            } while (c.moveToNext());

        }

        db.close();
        return apartamentos;
    }

    //Reporte # 3
    public static ArrayList<Apartamento> ApartamentosMayorTamanio(Context contexto){

        ArrayList<Apartamento> apartamentos = new ArrayList<>();

        //Declarar variables
        SQLiteDatabase db;
        String sql, nomenclatura, metrocuadrado, precio, piso, balcom, sombra;

        //Abrir conexión de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql = "SELECT * " +
                "FROM Apartamentos  " +
                "ORDER BY metroscuadrados LIMIT 1;";

        Cursor c = db.rawQuery(sql,null);

        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
                nomenclatura = c.getString(0);
                metrocuadrado = c.getString(1);
                precio = c.getString(2);
                piso = c.getString(3);
                balcom = c.getString(4);
                sombra = c.getString(5);

                a = new Apartamento(nomenclatura, metrocuadrado, precio, piso, balcom, sombra);
                apartamentos.add(a);

            } while (c.moveToNext());

        }

        db.close();
        return apartamentos;
    }

}

