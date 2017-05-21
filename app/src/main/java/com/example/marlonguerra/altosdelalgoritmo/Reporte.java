package com.example.marlonguerra.altosdelalgoritmo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte extends AppCompatActivity {


    private TextView reporte1;
    private TextView reporte2;
    private TextView reporte3;

    private TableLayout apartamentoCaro;
    private ArrayList<Apartamento> apartamentos2;

    private TableLayout apartamentoGrande;
    private ArrayList<Apartamento> apartamentos3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        //Reporte 1
        int cantidad = 0;
        cantidad = Datos.ApartamentosConSombraYBalcon(getApplicationContext());
        reporte1 = (TextView)findViewById(R.id.txtsomybal);
        reporte1.setText(String.valueOf(cantidad));

        //Reporte 2
        apartamentoCaro = (TableLayout)findViewById(R.id.tblapartamentosCaros);
        apartamentos2 = Datos.ApartamentosmasCaro(getApplicationContext());

        for (int i = 0; i <apartamentos2.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);
            TextView c7 = new TextView(this);


            c1.setText(""+(i+1));
            c2.setText(apartamentos2.get(i).getNomenclatura());
            c3.setText(apartamentos2.get(i).getMetrocuadrado());
            c4.setText(apartamentos2.get(i).getPrecio());
            c5.setText(apartamentos2.get(i).getPiso());
            c6.setText(apartamentos2.get(i).getBalcom());
            c7.setText(apartamentos2.get(i).getSombra());


            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);
            fila.addView(c7);

            apartamentoCaro.addView(fila);
        }

        /*Reporte 3*/

        apartamentoGrande = (TableLayout)findViewById(R.id.tblapartamentosTamanio);
        apartamentos3 = Datos.ApartamentosMayorTamanio(getApplicationContext());

        for (int i = 0; i <apartamentos3.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);
            TextView c7 = new TextView(this);


            c1.setText(""+(i+1));
            c2.setText(apartamentos3.get(i).getNomenclatura());
            c3.setText(apartamentos3.get(i).getMetrocuadrado());
            c4.setText(apartamentos3.get(i).getPrecio());
            c5.setText(apartamentos3.get(i).getPiso());
            c6.setText(apartamentos3.get(i).getBalcom());
            c7.setText(apartamentos3.get(i).getSombra());


            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);
            fila.addView(c7);

            apartamentoGrande.addView(fila);
        }



    /*
        for (int i = 0; i <apartamentos2.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);


            c1.setText(""+(i+1));
            c2.setText(apartamentos2.get(i).getNomenclatura());
            c3.setText(apartamentos2.get(i).getMetrocuadrado());


            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);


            PromedioTamañoPorPiso.addView(fila);
        }


*/
    }
    /*
    public void Reporte1(View v){
        Apartamento p;
        String balcom, sombra;
        if(validateRequestPermissionsRequestCode();) {
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
    */


}
