package com.example.Desafio1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private  EditText Nombre;
    private  EditText Apellido;
    private  EditText Cargo;
    private  EditText Horas;
    String[] nombre     = new String[3];
    String[] apellido   = new String[3];
    String[] cargo      = new String[3];
    String[] hora       = new String[3];
       int contador =   0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Nombre      =   (EditText)findViewById(R.id.et_nombre);
        Apellido    =   (EditText)findViewById(R.id.et_apellido);
        Cargo       =   (EditText)findViewById(R.id.et_cargo);
        Horas       =   (EditText)findViewById(R.id.et_horas);
    }

    public void SegundaPantalla(View view)
    {
        if(Integer.parseInt(Horas.getText().toString()) <= 0)
        {
            Toast.makeText(this, "Ha habido un error, ingrese de nuevo los valores", Toast.LENGTH_LONG).show();
        }
       else
        {
            if(contador==3)
            {

                Bundle bundle = new Bundle();
                bundle.putStringArray("arrayDatos", new String[]{nombre[0],nombre[1],nombre[2]});
                bundle.putStringArray("arrayDatos2", new String[]{apellido[0],apellido[1],apellido[2]});
                bundle.putStringArray("arrayDatos3", new String[]{cargo[0],cargo[1],cargo[2]});
                bundle.putStringArray("arrayDatos4", new String[]{hora[0],hora[1],hora[2]});
                Intent intent = new Intent(MainActivity.this, Resultados.class);
                intent.putExtras(bundle);
                startActivity(intent);
           }
            else
            {
                //Agregando los datos al arreglo ::::::::::::::::::::::
                nombre  [contador]   =    Nombre.getText().toString();
                apellido[contador]   =    Apellido.getText().toString();
                cargo   [contador]   =    (Cargo.getText().toString()).toLowerCase();
                hora    [contador]   =    Horas.getText().toString();

                contador++;
                Toast.makeText(this, "Personas registradas exitosamente: "+contador, Toast.LENGTH_SHORT).show();
            }


        }


    }
}
