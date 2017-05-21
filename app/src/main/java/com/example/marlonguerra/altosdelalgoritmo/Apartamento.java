package com.example.marlonguerra.altosdelalgoritmo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Marlon guerra on 20/05/2017.
 */

public class Apartamento {
    private String nomenclatura;
    private String metrocuadrado;
    private String precio;
    private String piso;
    private String balcom;
    private String sombra;

    public Apartamento(String nomenclatura, String metrocuadrado, String precio, String piso, String balcom, String sombra) {
        this.nomenclatura = nomenclatura;
        this.metrocuadrado = metrocuadrado;
        this.precio = precio;
        this.piso = piso;
        this.balcom = balcom;
        this.sombra = sombra;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getMetrocuadrado() {
        return metrocuadrado;
    }

    public void setMetrocuadrado(String metrocuadrado) {
        this.metrocuadrado = metrocuadrado;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getBalcom() {
        return balcom;
    }

    public void setBalcom(String balcom) {
        this.balcom = balcom;
    }

    public String getSombra() {
        return sombra;
    }

    public void setSombra(String sombra) {
        this.sombra = sombra;
    }

    public void guardar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        PersonasSQLiteOpenHelper  aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "INSERT INTO Apartamentos values('"
                +this.getNomenclatura()+"','"
                +this.getMetrocuadrado()+"','"
                +this.getPrecio()+"','"
                +this.getPiso()+"','"
                +this.getBalcom()+"','"
                +this.getSombra()+"')";


        db.execSQL(sql);

        //insert forma 2

      /*  ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("foto",this.getFoto());
        nuevoRegistro.put("cedula",this.getCedula());
        nuevoRegistro.put("nombre",this.getNombre());
        nuevoRegistro.put("apellido",this.getApellido());
        nuevoRegistro.put("sexo",this.getSexo());
        nuevoRegistro.put("pasatiempo",this.getPasatiempo());

        db.insert("Personas",null,nuevoRegistro);
*/
        //cerrar conexion
        db.close();

    }

    public void eliminar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        PersonasSQLiteOpenHelper  aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM Apartamentos where nomenclatura='"+this.getNomenclatura()+"'";
        db.execSQL(sql);
        db.close();

    }

    public void modificar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        PersonasSQLiteOpenHelper  aux = new PersonasSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "UPDATE Apartamentos SET metrocuadrado='"+this.getMetrocuadrado()+"', precio='"+this.getPrecio()+"', piso='"+this.getPiso()+"', " + "balcom='" +this.getBalcom()+"' " + "sombra='" +this.getSombra()+"' " + "where nomenclatura ='"+this.getNomenclatura()+"'";

        db.execSQL(sql);

        //cerrar conexion
        db.close();

    }

}
