package com.example.ciclovida;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int contCreate = 0, contStart=0, contResume=0, contPause=0, contStop=0, contRestart=0;
    private TextView tvCreate, tvStart, tvResume, tvPause, tvStop, tvRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contCreate++;

        tvCreate = (TextView)findViewById(R.id.tv_onCreate_act1);
        tvStart = (TextView)findViewById(R.id.tv_onStart_act1);
        tvResume = (TextView)findViewById(R.id.tv_onResume_act1);
        tvPause = (TextView)findViewById(R.id.tv_onPause_act1);
        tvStop = (TextView)findViewById(R.id.tv_onStop_act1);

        tvCreate.setText("onCreate: "+ contCreate);



        tvStop.setText("onStop: "+contStop);
    }
    @Override
    protected void onStart() {
        super.onStart();
        contStart++;
        tvStart.setText("onStart: "+ contStart);
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {

        super.onResume();
        contResume++;
        tvResume.setText("onResume: "+ contResume);
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {

        super.onPause();
        contPause++;
        tvPause.setText("onPause: "+ contPause);
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {

        super.onStop();
        contStop++;
        tvStop.setText("onStop: "+contStop);
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("this's landscape");

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            System.out.println("this's portrait");
        }
    }

    public void Siguiente (View view){
        Intent intent = new Intent(MainActivity.this, activity2.class);
        startActivity(intent);


    }
}
