package com.example.autogreenhouse_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autogreenhouse_application.api.Api;
import com.example.autogreenhouse_application.models.Plant;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ModificarPlanta extends AppCompatActivity {

    EditText edit_name, edit_description, edit_air_temperature, edit_air_humidity, edit_ground_humidity,
            edit_quantity_fertilizer;

    Plant plantResponseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_planta);

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_description = (EditText) findViewById(R.id.edit_description);
        edit_air_temperature = (EditText) findViewById(R.id.edit_air_temperature);
        edit_air_humidity = (EditText) findViewById(R.id.edit_air_humidity);
        edit_ground_humidity = (EditText) findViewById(R.id.edit_ground_humidity);
        edit_quantity_fertilizer = (EditText) findViewById(R.id.edit_quantity_fertilizer);

        getPlantData();

        Button botonAceptarMod = findViewById(R.id.botonAceptarMod);
        botonAceptarMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putPlanta();
                Intent intent = new Intent (v.getContext(), ParametrosInvernadero.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    private void putPlanta() {
        final ProgressDialog progressDialog = new ProgressDialog(ModificarPlanta.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().registration(edit_name.getText().toString().trim(),
                edit_description.getText().toString().trim(),
                Double.parseDouble(edit_air_temperature.getText().toString().trim()),
                Double.parseDouble(edit_air_humidity.getText().toString().trim()),
                Double.parseDouble(edit_ground_humidity.getText().toString().trim()),
                Double.parseDouble(edit_quantity_fertilizer.getText().toString().trim()),
                new Callback<Plant>() {
                    @Override
                    public void success(Plant plantResponse, Response response) {
                        progressDialog.dismiss();
                        plantResponseData = plantResponse;
                        Toast.makeText(ModificarPlanta.this, "Planta modificada con exito", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(ModificarPlanta.this, error.toString(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                });
    }

    private void getPlantData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(ModificarPlanta.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getPlant(new Callback<Plant>() {
            @Override
            public void success(Plant plantResponses, Response response) {
                progressDialog.dismiss();
                plantResponseData = plantResponses;
                edit_name.append(plantResponseData.getName());
                edit_description.append(plantResponseData.getDescription());
                edit_air_temperature.append(String.valueOf(plantResponseData.getAir_temperature()));
                edit_air_humidity.append(String.valueOf(plantResponseData.getAir_humidity()));
                edit_ground_humidity.append(String.valueOf(plantResponseData.getGround_humidity()));
                edit_quantity_fertilizer.append(String.valueOf(plantResponseData.getQuantity_fertilizer_week()));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ModificarPlanta.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

}
