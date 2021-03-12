package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class NexoEpi extends AppCompatActivity {
    private Button bc2;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private String user,id;
    private int resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo_epi);

        bc2= findViewById(R.id.bc2);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);


        //Vasijas
        user = getIntent().getExtras().getString("user");
        id = getIntent().getExtras().getString("id");

       cb1.setOnClickListener(
               v -> {

                   boton();
               }

       );

        cb2.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cb3.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cb4.setOnClickListener(
                v -> {

                    boton();
                }

        );

        cb5.setOnClickListener(
                v -> {

                    boton();
                }

        );



        bc2.setOnClickListener(

                v -> {
                    verificacioncheck();


                    Intent i=new Intent(this,Sintomas.class);
                    i.putExtra("user",user);
                    i.putExtra("id",id);
                    i.putExtra("resultado",resultado);

                    startActivity(i);
                    finish();

                }

        );




    }
    private void boton(){
        if(cb1.isChecked() == true || cb2.isChecked()==true || cb3.isChecked()==true || cb4.isChecked()==true || cb5.isChecked()==true ){
            Toast aviso = Toast.makeText(this,"entra",Toast.LENGTH_LONG);
            aviso.show();
            bc2.setEnabled(true);
            bc2.setBackgroundColor(Color.parseColor("#F01856"));

        }if(cb1.isChecked() == false && cb2.isChecked()==false && cb3.isChecked()==false && cb4.isChecked()==false && cb5.isChecked()==false ){

            bc2.setEnabled(false);
            bc2.setBackgroundColor(Color.parseColor("#b1b1b1"));

        }

    }

    private void verificacioncheck() {
        if(cb1.isChecked()){

            resultado +=3;

        }

        if(cb2.isChecked()){

            resultado +=3;

        }

        if(cb3.isChecked()){

            resultado +=3;

        }

        if(cb4.isChecked()){

            resultado +=3;

        }

        if(cb5.isChecked()){

            resultado +=0;

        }



    }
}