package com.example.logincorreo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParImparActivity extends AppCompatActivity {

    EditText et_numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.par_impar_activity);

        et_numero = (EditText)findViewById(R.id.et_numero);
    }


    public void BotonComprobar (){
        ComprobarNumero(Integer.parseInt(et_numero.toString()));
    }

    public void ComprobarNumero(int numero){
        int contador = 0;

        for(int i = 1; i <= numero; i++)
        {
            if((numero % i) == 0)
            {
                contador++;
            }
        }

        if(contador <= 2)
        {
            Toast.makeText(this,"El numero es primo",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"El numero no es primo",Toast.LENGTH_LONG).show();
        }
    }
}