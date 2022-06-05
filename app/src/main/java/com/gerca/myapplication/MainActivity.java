package com.gerca.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button ingre;
    TextView recupe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingre=(Button)findViewById(R.id.btningresar);
        recupe=(TextView)findViewById(R.id.recuperar) ;

        ingre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Intent i= new Intent( MainActivity.this,MenuPrincipal.class);
               // startActivity(i);
                Toast.makeText (getApplicationContext(),
                                "Pulsaste el boton Ingresar",Toast.LENGTH_LONG)
                        .show();
            }
        });

        recupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent( MainActivity.this, RecuperarClave.class);
                startActivity(i);

            }
        });
    }
}