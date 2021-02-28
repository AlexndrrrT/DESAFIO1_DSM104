package com.example.Desafio1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class Resultados extends AppCompatActivity
{
    private TextView tvNombre, tvApellido, tvCargo, tvHoras, tvISSS, tvAFP, tvRenta, Salario, tvbono, tvSalarioMaximo, tvSalarioMinimo, tvCantidad;
    double SalarioBruto=0, isss=0, afp=0, renta=0, SalarioNeto=0, bono=0, SalarioMax=0, SalarioMin=0;
    boolean orden = false;
    int valorhoras=0,indicedelmayorsalario=0,indicedelmenorsalario=0,contadormayordetrecientos=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        tvNombre        =  (TextView) findViewById(R.id.tv_nombre);
        tvApellido      =  (TextView) findViewById(R.id.tv_apellido);
        tvCargo         =  (TextView) findViewById(R.id.tv_cargo);
        tvHoras         =  (TextView) findViewById(R.id.tv_horas);
        tvISSS          =  (TextView) findViewById(R.id.tv_seguro);
        Salario         =  (TextView) findViewById(R.id.tv_salario);
        tvAFP           =  (TextView) findViewById(R.id.tv_pension);
        tvRenta         =  (TextView) findViewById(R.id.tv_renta);
        tvbono          =  (TextView) findViewById(R.id.tv_bono);
        tvSalarioMaximo =  (TextView) findViewById(R.id.tv_1_2);
        tvSalarioMinimo =  (TextView) findViewById(R.id.tv_2_2);
        tvCantidad      =  (TextView) findViewById(R.id.tv_3_3);

        Bundle bundle = getIntent().getExtras();

        String[] Nombre = bundle.getStringArray("arrayDatos");
        String[] Apellido = bundle.getStringArray("arrayDatos2");
        String[] Cargo = bundle.getStringArray("arrayDatos3");
        String[] Horas = bundle.getStringArray("arrayDatos4");
        String nombres="";
        String apellidos="";
        String cargos="";
        String horas="";
        String Isss="";
        String Renta="";
        String Afp ="";
        String SaNeto ="";
        String Bonos ="";

        nombres     += "Nombre" + '\n';
        apellidos   +=  "Apellido" + '\n';
        cargos      += "Cargo" + '\n';
        horas       +=  "Horas" + '\n';
        Isss        +=  "ISSS" + '\n';
        Renta       +=  "Renta" + '\n';
        Afp         +=  "AFP" + '\n';
        SaNeto      +=  "Salario Neto" + '\n';
        Bonos      +=  "Bono" + '\n';

        if(Cargo[0].equals("gerente") && Cargo[1].equals("asistente") && Cargo[2].equals("secretaria"))
        {
            orden =true;
        }
        for(int i=0;i<=2;i++)
        {
            isss=0;
            renta=0;
            afp=0;
            SalarioNeto =0;
            bono=0;
            nombres     +=  Nombre[i] + '\n';
            apellidos   +=  Apellido[i] + '\n';
            cargos      +=  Cargo[i] + '\n';
            horas       +=  Horas[i] + '\n';

            valorhoras = Integer.parseInt(Horas[i]);
            if(Integer.parseInt(Horas[i])<=160)
            {
                SalarioBruto = valorhoras*9.75;
            }
            if(Integer.parseInt(Horas[i])>160)
            {
                SalarioBruto = 160*9.75;
                SalarioBruto = SalarioBruto + (valorhoras-160)*11.50;
            }
            isss        =   Math.round( (SalarioBruto*0.0525)*100.0)/100;
            renta       =   Math.round((SalarioBruto*0.0688)*100.0)/100;
            afp         =   Math.round((SalarioBruto*0.1)*100.0)/100;
            SalarioNeto =   Math.round((SalarioBruto - (isss+renta+afp))*100)/100;
            //Toast.makeText(this, Cargo[i], Toast.LENGTH_LONG).show();
            if(orden == true)
            {
                String IssS     = valueOf(isss);
                String RenTa    = valueOf(renta);
                String AfP      = valueOf(afp);
                String Sneto    = valueOf(SalarioNeto);
                String bOnos    = valueOf(bono);
                Isss       +=  IssS + '\n';
                Renta       +=  RenTa + '\n';
                Afp       +=  AfP + '\n';
                SaNeto       +=  Sneto + '\n';
                Bonos      +=  "No hay bonos disponibles" + '\n';
            }
            else
            {
                switch(Cargo[i])
                {
                    case "gerente":
                        bono =  Math.round((SalarioNeto*0.1)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                    case "asistente":
                        bono = Math.round((SalarioNeto*0.05)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                    case "secretaria":
                        bono = Math.round((SalarioNeto*0.03)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                    default:
                        bono = Math.round((SalarioNeto*0.02)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                }
                String IssS     = valueOf(isss);
                String RenTa    = valueOf(renta);
                String AfP      = valueOf(afp);
                String Sneto    = valueOf(SalarioNeto);
                String bOnos    = valueOf(bono);
                Isss       +=  IssS + '\n';
                Renta       +=  RenTa + '\n';
                Afp       +=  AfP + '\n';
                SaNeto       +=  Sneto + '\n';
                Bonos      +=  bOnos + '\n';
            }

            if(i==0)
            {
                indicedelmayorsalario = i;
                SalarioMax=SalarioNeto;
                SalarioMin=SalarioNeto;
            }
            if(i!=0)
            {
                if(SalarioNeto < SalarioMax)
                {
                    SalarioMin = SalarioNeto;
                    indicedelmenorsalario = i;
                }
                else
                {
                    SalarioMax = SalarioNeto;
                    indicedelmayorsalario = i;
                }
            }
            if(SalarioNeto>300)
            {
                contadormayordetrecientos++;
            }
            tvNombre.setText(nombres);
            tvApellido.setText(apellidos);
            tvCargo.setText(cargos);
            tvHoras.setText(horas);
            tvISSS.setText(Isss);
            tvAFP.setText(Afp);
            tvRenta.setText(Renta);
            Salario.setText(SaNeto);
            tvbono.setText(Bonos);
        }


        String ContadorMayorTRE = valueOf(contadormayordetrecientos);
        String Smaximo    = valueOf(Nombre[indicedelmayorsalario]);
        String Sminimo    = valueOf(Nombre[indicedelmenorsalario]);
        tvSalarioMaximo.setText(Smaximo);
        tvSalarioMinimo.setText(Sminimo);
        tvCantidad.setText(ContadorMayorTRE);


    }
    public void finalizar(View view)
    {
        Intent intent = new Intent(Resultados.this, MainActivity.class);
        startActivity(intent);
    }
}
