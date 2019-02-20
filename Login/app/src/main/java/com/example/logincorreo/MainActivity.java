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

       // btn_ingresar.findViewById(R.id.btn_comprobar);
//        btn_ingresar.setOnClickListener(myhandler1);

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


//    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick (View v){
            boolean esValido = isEmailValid(et_correo.getText().toString());

            if (esValido){
                Intent intent= new Intent(MainActivity.this, PrimoActivity.class);
                intent.putExtra("Usuario", et_correo.getText().toString());
                startActivity(intent);
            }

        }
//    };
}
