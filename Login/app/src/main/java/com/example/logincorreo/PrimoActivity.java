package com.example.logincorreo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrimoActivity extends AppCompatActivity {

    private TextView tv_usuario;
    private EditText et_numero;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.par_impar_activity);

        String usuario = getIntent().getStringExtra("Usuario");

        tv_usuario = (TextView)findViewById(R.id.tv_usuario);
        tv_usuario.setText(usuario);

        et_numero = (EditText)findViewById(R.id.et_numero);

        //boton.findViewById(R.id.btn_evaluar);
    }


    public void BotonComprobar (View view){
//        ComprobarNumero(Integer.parseInt(et_numero.getText().toString()));
        String valor = et_numero.getText().toString();
        int num = Integer.parseInt(valor);

        int contador = 2;
        boolean primo = true;
        String resul="";

        while ((primo)&&(contador != num)) {
            if (num % contador == 0 || num == 1){
                primo = false;
            }
            contador++;
        }
        if (primo == false){
            Toast.makeText(this,"El número no es primo",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"El número es primo",Toast.LENGTH_LONG).show();
        }

        Intent intent= new Intent(PrimoActivity.this, MainActivity.class);
        startActivity(intent);
    }

//    public void ComprobarNumero(int numero){
//        int contador = 0;
//
//        for(int i = 1; i <= numero; i++)
//        {
//            if((numero % i) == 0)
//            {
//                contador++;
//            }
//        }
//
//        if(contador <= 2)
//        {
//            Toast.makeText(this,"El numero es primo",Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(this,"El numero no es primo",Toast.LENGTH_LONG).show();
//        }
//    }
}