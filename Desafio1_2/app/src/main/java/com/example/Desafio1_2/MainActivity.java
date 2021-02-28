package com.example.Desafio1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.lang.String;
import java.util.Arrays;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private EditText votos;
    private TextView tv1, tv2, tv3, tv4, tv5;
    private TextView r1, r2, r3, r4, r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        votos = (EditText)findViewById(R.id.et_votos);
        tv1 = (TextView)findViewById(R.id.tv_candidato1);
        tv2 = (TextView)findViewById(R.id.tv_candidato2);
        tv3 = (TextView)findViewById(R.id.tv_candidato3);
        tv4 = (TextView)findViewById(R.id.tv_candidato4);
        tv5 = (TextView)findViewById(R.id.tv_votosanulados);
        r1 = (TextView)findViewById(R.id.tv_res1);
        r2 = (TextView)findViewById(R.id.tv_res2);
        r3 = (TextView)findViewById(R.id.tv_res3);
        r4 = (TextView)findViewById(R.id.tv_res4);
        r5 = (TextView)findViewById(R.id.tv_resvotosanulados);

    }

    public void votos (View view)
    {
        String datos = votos.getText().toString();

        String[] parts = datos.split("\\,");

        int total = parts.length;
        int voto1=0;
        int voto2=0;
        int voto3=0;
        int voto4=0;
        int voto5=0;

        List<String> lista = Arrays.asList(parts);

        for (String part : lista)
        {
            if (part.equals("1"))
            {
                voto1++;
            }
            else if (part.equals("2"))
            {
                voto2++;
            }
            else if (part.equals("3"))
            {
                voto3++;
            }
            else if (part.equals("4"))
            {
                voto4++;
            }
            else
            {
                voto5++;
            }
        }

        double por1 = (voto1*100/total);
        double por2 = (voto2*100/total);
        double por3 = (voto3*100/total);
        double por4 = (voto4*100/total);
        double por5 = (voto5*100/total);


        r1.setText("" + voto1 + " votos que equivalen al (" + por1 + ")%");
        r2.setText("" + voto2 + " votos que equivalen al (" + por2 + ")%");
        r3.setText("" + voto3 + " votos que equivalen al (" + por3 + ")%");
        r4.setText("" + voto4 + " votos que equivalen al (" + por4 + ")%");
        r5.setText("" + voto5 + " votos que equivalen al (" + por5 + ")%");

    }
}