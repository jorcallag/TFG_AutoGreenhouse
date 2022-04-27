package com.example.autogreenhouse_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionDispositivo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_dispositivo);

        Button botonSeleccionDispositivo = findViewById(R.id.botonSeleccionDispositivo);
        botonSeleccionDispositivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ParametrosInvernadero.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}
