package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText nombre;
    private EditText identificacion;
    private Button bc1;
    private Boolean vacio;
    private Boolean verificacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.nombre);
        identificacion = findViewById(R.id.identificacion);
        bc1 = findViewById(R.id.bc1);


        bc1.setOnClickListener(

                v -> {
                    vacio = nombre.getText().toString().isEmpty() || identificacion.getText().toString().isEmpty();

                    if(vacio==true){
                        Toast aviso = Toast.makeText(this,"Necesaria más información",Toast.LENGTH_LONG);
                        aviso.show();

                    } else {
                        verificacionid();
                        if(verificacion==false) {
                            String user = nombre.getText().toString();

                            String id = identificacion.getText().toString();

                            Intent i = new Intent(this, NexoEpi.class);


                            i.putExtra("user",user);
                            i.putExtra("id",id);


                            startActivity(i);
                            finish();
                        }
                    }



                }

        );




    }

    private void verificacionid() {

        SharedPreferences preferences= getSharedPreferences("base",MODE_PRIVATE);
        String recogida= preferences.getString("user","No hay datos");

        if(recogida.contains(identificacion.getText().toString())){
            Toast error = Toast.makeText(this,"Ya cuenta con registro", Toast.LENGTH_LONG);
            error.show();
            verificacion = true;
            return;
        }
       verificacion= false;
    }



}