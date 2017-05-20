package com.example.marlonguerra.altosdelalgoritmo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText cajanomenclatura;
    private EditText cajaprecio;
    private EditText cajapiso;
    private EditText cajametrocuadrado;

    private CheckBox chkbalcon;
    private CheckBox chksombra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        cajanomenclatura = (EditText)findViewById(R.id.txtnomenclatura);
        cajaprecio = (EditText)findViewById(R.id.txtprecio);
        cajapiso = (EditText)findViewById(R.id.txtpiso);
        cajametrocuadrado = (EditText)findViewById(R.id.txtmetroscuadrados);

        chkbalcon = (CheckBox)findViewById(R.id.chkbalcon);
        chksombra = (CheckBox)findViewById(R.id.chksombra);
    }


    public boolean validarTodo(){
        if(cajanomenclatura.getText().toString().isEmpty()){
            cajanomenclatura.setError(this.getResources().getString(R.string.error_1));
            cajanomenclatura.requestFocus();
            return false;
        }
        if(cajaprecio.getText().toString().isEmpty()){
            cajaprecio.setError(this.getResources().getString(R.string.error_2));
            cajaprecio.requestFocus();
            return false;
        }
        if(cajapiso.getText().toString().isEmpty()){
            cajapiso.setError(this.getResources().getString(R.string.error_3));
            cajapiso.requestFocus();
            return false;
        }
        if(cajametrocuadrado.getText().toString().isEmpty()){
            cajametrocuadrado.setError(this.getResources().getString(R.string.error_4));
            cajametrocuadrado.requestFocus();
            return false;
        }

        return true;
    }

    public void guardar(View v){



        String nomenclatura, metrocuadrado, precio, piso, balcom = "",sombra = "";
        Apartamento p;

        if(validarTodo()){
            nomenclatura = cajanomenclatura.getText().toString();
            metrocuadrado = cajametrocuadrado.getText().toString();
            precio = cajaprecio.getText().toString();
            piso = cajapiso.getText().toString();

            if(chkbalcon.isChecked()){
                balcom = getResources().getString(R.string.balcon);
            }
            if(chksombra.isChecked()){
                sombra = getResources().getString(R.string.sombra);
            }

            p = new Apartamento(nomenclatura, metrocuadrado, precio, piso, balcom, sombra);
            p.guardar(getApplicationContext());

            Toast.makeText(getApplicationContext(), this.getResources().getString(R.string.mens_1),
                    Toast.LENGTH_SHORT).show();

            limpiar();

        }
    }

   /* public int fotoAleatoria(){
        int fotos[] = {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int numero = (int)(Math.random() * 3);
        return fotos[numero];
    }
    */
    public boolean validarNomenclatura() {
        if (cajanomenclatura.getText().toString().isEmpty()) {
            cajanomenclatura.setError(this.getResources().getString(R.string.error_1));
            cajanomenclatura.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(){
        cajanomenclatura.setText("");
        cajapiso.setText("");
        cajaprecio.setText("");
        cajametrocuadrado.setText("");
        chkbalcon.setChecked(false);
        chksombra.setChecked(false);
        cajanomenclatura.requestFocus();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void buscar(View v){
        Apartamento p;
        String balcom, sombra;;
        if(validarNomenclatura()) {
            p = Datos.buscarApartamento(getApplicationContext(), cajanomenclatura.getText().toString());
            if(p!=null){
                cajametrocuadrado.setText(p.getMetrocuadrado());
                cajaprecio.setText(p.getPrecio());
                cajapiso.setText(p.getPiso());
                balcom = p.getBalcom();
                if(balcom.contains(getResources().getString(R.string.balcon))) chkbalcon.setChecked(true);
                sombra = p.getSombra();
                if(sombra.contains(getResources().getString(R.string.sombra))) chksombra.setChecked(true);
            }
        }
    }

    public void modificar(View v){
        Apartamento p,p2;
        String metrocuadrado, precio, piso, balcom="", sombra="";
        if(validarNomenclatura()) {
            p = Datos.buscarApartamento(getApplicationContext(), cajanomenclatura.getText().toString());
            if(p!=null){

                metrocuadrado = cajametrocuadrado.getText().toString();
                precio = cajaprecio.getText().toString();
                piso = cajapiso.getText().toString();

                if(chkbalcon.isChecked()){
                    balcom = getResources().getString(R.string.balcon);
                }

                if(chksombra.isChecked()){
                    sombra = getResources().getString(R.string.sombra);
                }

                p2 = new Apartamento(p.getNomenclatura(),metrocuadrado, precio, piso, balcom, sombra);
                p2.modificar(getApplicationContext());

                Toast.makeText(getApplicationContext(), this.getResources().getString(R.string.mens_mod),
                        Toast.LENGTH_SHORT).show();
                limpiar();

            }
        }
    }

    public void eliminar(View v){
        Apartamento p;
        if(validarNomenclatura()) {
            p = Datos.buscarApartamento(getApplicationContext(), cajanomenclatura.getText().toString());
            if(p!=null){
                AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setTitle(this.getResources().getString(R.string.confirmar));
                ventana.setMessage(this.getResources().getString(R.string.conf_eliminar));
                ventana.setPositiveButton(this.getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Apartamento p;
                        p = Datos.buscarApartamento(getApplicationContext(), cajanomenclatura.getText().toString());

                        p.eliminar(getApplicationContext());
                        limpiar();
                        Toast.makeText(getApplicationContext(), "Apartamento Eliminado Exitosamente",
                                Toast.LENGTH_SHORT).show();

                    }
                });

                ventana.setNegativeButton(this.getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cajanomenclatura.requestFocus();
                    }
                });

                ventana.show();
            }
        }
    }


}
