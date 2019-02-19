package com.example.logincorreo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText et_correo, et_contraseña;
    private Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_correo = (EditText)findViewById(R.id.et_correo);
        et_contraseña = (EditText)findViewById(R.id.et_contraseña);


    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


    public void BotonAceptar (View vista){
        boolean esValido = isEmailValid(et_correo.getText().toString());

        if (esValido){
            Intent intent= new Intent(MainActivity.this, ParImparActivity.class);
            intent.putExtra("Usuario", et_correo.getText().toString());
            startActivity(intent);
        }

    }
}
