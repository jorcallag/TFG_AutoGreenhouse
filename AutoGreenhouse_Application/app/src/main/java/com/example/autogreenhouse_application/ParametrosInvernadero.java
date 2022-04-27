package com.example.autogreenhouse_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ParametrosInvernadero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametros_invernadero);

        Button botonInfoPlanta = findViewById(R.id.botonInfoPlanta);
        botonInfoPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), InfoPlanta.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
