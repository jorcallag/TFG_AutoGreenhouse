package com.example.autogreenhouse_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InfoPlanta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_planta);

        Button botonModificarPlanta = findViewById(R.id.botonModificarPlanta);
        botonModificarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ModificarPlanta.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
