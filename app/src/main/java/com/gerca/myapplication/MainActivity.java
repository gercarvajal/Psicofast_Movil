package com.gerca.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    Button ingre;
    TextView recupe;
    EditText usuario,password;
    RequestQueue datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingre=(Button)findViewById(R.id.btningresar);
        recupe=(TextView)findViewById(R.id.recuperar) ;

        usuario=(EditText) findViewById(R.id.frmusuario);
        password=(EditText) findViewById(R.id.frmclave);
        datos= Volley.newRequestQueue(this);



        ingre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i= new Intent( MainActivity.this,MenuPrincipal.class);
                startActivity(i);
              //  Toast.makeText (getApplicationContext(),
                 //               "Pulsaste el boton Ingresar",Toast.LENGTH_LONG)
                  //      .show();

              //  consultardatos(usuario.getText().toString(),password.getText().toString());
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


    public void consultardatos(String usu, String pass) {
        String url="http://psicofast.space/Sycofast/consultadatos.php?usu="+usu+"&pass="+pass;
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            String estado=response.getString("estado");
                            if(estado.equals("0")) {
                                Toast.makeText(MainActivity.this,"Usuario no Existe",Toast.LENGTH_LONG).show();
                            }else{

                                Intent i= new Intent( MainActivity.this, RecuperarClave.class);
                                startActivity(i);
                                i.putExtra("rut", usu);
                                startActivity(i);
                            }
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        datos.add(request);
    }
}