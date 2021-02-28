package com.example.desafio1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calcularEcuacion(View v)
    {
        double x1, x2;

        EditText snumA = (EditText)findViewById(R.id.txtnumA);
        EditText snumB = (EditText)findViewById(R.id.txtnumB);
        EditText snumC = (EditText)findViewById(R.id.txtnumC);
        TextView sResultado = (TextView) findViewById(R.id.lblResultado);

        double a = Double.parseDouble(snumA.getText().toString());
        double b = Double.parseDouble(snumB.getText().toString());
        double c = Double.parseDouble(snumC.getText().toString());
        double d = ((b*b)-4*a*c);

        if(d<0){
            sResultado.setText("No existe solucion a la formula");
        }
        else
            {
            x1 = ( -b + Math.sqrt(d))/(2*a);

            x2 = ( -b - Math.sqrt(d))/(2*a);

            sResultado.setText("Solución X (+): " + x1 + "\n Solución X (-): "+ x2);


        }
    }