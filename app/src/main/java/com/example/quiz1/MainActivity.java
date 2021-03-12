package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button br;
    private TextView usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        br = findViewById(R.id.br);
        usuarios = findViewById(R.id.usuarios);



        br.setOnClickListener(
                v -> {
                    Intent i = new Intent(this,Registro.class);

                    startActivity(i);

                }

        );




    }

    @Override
    protected void onResume() {
        super.onResume();
        String info = getSharedPreferences("base", MODE_PRIVATE).getString("user","No hay datos");
        usuarios.setText(info);
    }



}