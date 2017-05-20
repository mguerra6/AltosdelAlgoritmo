package com.example.marlonguerra.altosdelalgoritmo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Reporte extends AppCompatActivity {
    private EditText reporte1;
    private EditText reporte2;
    private EditText reporte3;
    private EditText reporte4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
        reporte1 = (EditText)findViewById(R.id.txtsombraybalcon);
        reporte2 = (EditText)findViewById(R.id.txtapartamentocaro);
        reporte3 = (EditText)findViewById(R.id.txtapartamentogrande);
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
