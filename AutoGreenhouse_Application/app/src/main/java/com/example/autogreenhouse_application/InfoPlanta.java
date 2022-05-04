package com.example.autogreenhouse_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autogreenhouse_application.api.Api;
import com.example.autogreenhouse_application.models.Plant;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class InfoPlanta extends AppCompatActivity {

    private TextView nombre_plant, descripcion_plant, air_temperature_plant, air_humidity_plant, ground_humidity_plant,
            quantity_fertilizer_plant;

    Plant plantResponseData;

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

        nombre_plant = findViewById(R.id.nombre_plant);
        descripcion_plant = findViewById(R.id.descripcion_plant);
        air_temperature_plant = findViewById(R.id.air_temperature_plant);
        air_humidity_plant = findViewById(R.id.air_humidity_plant);
        ground_humidity_plant = findViewById(R.id.ground_humidity_plant);
        quantity_fertilizer_plant = findViewById(R.id.quantity_fertilizer_plant);

        getPlantData();
    }

    private void getPlantData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(InfoPlanta.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Porfavor espere");
        progressDialog.show();

        Api.getClient().getPlant(new Callback<Plant>() {
            @Override
            public void success(Plant plantResponses, Response response) {
                progressDialog.dismiss();
                plantResponseData = plantResponses;
                nombre_plant.append(plantResponseData.getName());
                descripcion_plant.append(plantResponseData.getDescription());
                air_temperature_plant.append(String.valueOf(plantResponseData.getAir_temperature()));
                air_humidity_plant.append(String.valueOf(plantResponseData.getAir_humidity()));
                ground_humidity_plant.append(String.valueOf(plantResponseData.getGround_humidity()));
                quantity_fertilizer_plant.append(String.valueOf(plantResponseData.getQuantity_fertilizer_week()));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(InfoPlanta.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

}
