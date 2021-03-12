package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class Sintomas extends AppCompatActivity {

    private Button bc3;
    private CheckBox cbb1;
    private CheckBox cbb2;
    private CheckBox cbb3;
    private CheckBox cbb4;
    private CheckBox cbb5;
    private CheckBox cbb6;
    private CheckBox cbb7;
    private String user,id;
    private int resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        bc3 = findViewById(R.id.bc3);
        cbb1 = findViewById(R.id.cbb1);
        cbb2 = findViewById(R.id.cbb2);
        cbb3 = findViewById(R.id.cbb3);
        cbb4 = findViewById(R.id.cbb4);
        cbb5 = findViewById(R.id.cbb5);
        cbb6 = findViewById(R.id.cbb6);
        cbb7 = findViewById(R.id.cbb7);

        //Vasijas
        user = getIntent().getExtras().getString("user");
        id = getIntent().getExtras().getString("id");
        resultado = getIntent().getExtras().getInt("resultado");

        cbb1.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cbb2.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cbb3.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cbb4.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cbb5.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cbb6.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cbb7.setOnClickListener(
                v -> {

                    boton();
                }

        );

        bc3.setOnClickListener(
                v -> {
                    verificacionchecksin();

                    Intent i = new Intent(this,MainActivity.class);
                    guardar();
                    startActivity(i);
                    finish();
                }


        );


    }

    private void boton(){

        if(cbb1.isChecked() == true || cbb2.isChecked()==true || cbb3.isChecked()==true || cbb4.isChecked()==true || cbb5.isChecked()==true || cbb6.isChecked()==true || cbb7.isChecked()==true ){

            bc3.setEnabled(true);
            bc3.setBackgroundColor(Color.parseColor("#F01856"));

        }if(cbb1.isChecked() == false && cbb2.isChecked()==false && cbb3.isChecked()==false && cbb4.isChecked()==false && cbb5.isChecked()==false && cbb6.isChecked()==false && cbb7.isChecked()==false ){

            bc3.setEnabled(false);
            bc3.setBackgroundColor(Color.parseColor("#b1b1b1"));

        }

    }

    private void verificacionchecksin() {
        if(cbb1.isChecked()){

            resultado +=4;

        }

        if(cbb2.isChecked()){

            resultado +=4;

        }

        if(cbb3.isChecked()){

            resultado +=4;

        }

        if(cbb4.isChecked()){

            resultado +=4;

        }

        if(cbb5.isChecked()){

            resultado +=4;

        }

        if(cbb6.isChecked()){

            resultado +=4;

        }

        if(cbb7.isChecked()){

            resultado +=0;

        }
    }

    private void guardar(){
        SharedPreferences preferences = getSharedPreferences("base", MODE_PRIVATE);
        String lista = preferences.getString("user","");
        String registro = user + ", " + id + ", " + resultado + "\n" ;
        preferences.edit().putString("user", lista + registro ).apply();


    }
}