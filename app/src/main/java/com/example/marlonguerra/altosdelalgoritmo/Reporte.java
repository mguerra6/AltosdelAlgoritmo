package com.example.marlonguerra.altosdelalgoritmo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte extends AppCompatActivity {
    private EditText reporte1;
    private EditText reporte2;
    private EditText reporte3;

    private TableLayout PromedioTamañoPorPiso;
    private ArrayList<Apartamento> apartamentos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        reporte1 = (EditText)findViewById(R.id.txtsomybal);
        reporte2 = (EditText)findViewById(R.id.txtapartamentocaro);
        reporte3 = (EditText)findViewById(R.id.txtapartamentogrande);

        PromedioTamañoPorPiso = (TableLayout)findViewById(R.id.tblPromedioTamañoPorPiso);
        apartamentos2 = Datos.traerPersonas(getApplicationContext());

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



    }
    public void Reporte1(View v){
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
}
