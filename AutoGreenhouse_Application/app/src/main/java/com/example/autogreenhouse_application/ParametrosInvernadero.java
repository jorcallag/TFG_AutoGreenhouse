package com.example.autogreenhouse_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autogreenhouse_application.api.Api;
import com.example.autogreenhouse_application.models.Actuator_Value;
import com.example.autogreenhouse_application.models.Device;
import com.example.autogreenhouse_application.models.Plant;
import com.example.autogreenhouse_application.models.Sensor_Value;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ParametrosInvernadero extends AppCompatActivity {

    private TextView nombre_dispositivo, air_temperature, air_humidity, ground_humidity, luminosity,
            fertilizer_level, humidif_level, extractor, heating, leds, valve, pump, humidif;

    Device deviceResponseData;

    Sensor_Value airTemperatureResponseData, airHumidityResponseData, groundHumidityResponseData, luminosityResponseData,
            fertilizerLevelResponseData, humidifLevelResponseData;

    Actuator_Value extractorResponseData, heatingResponseData, ledsResponseData, valveResponseData, pumpResponseData,
            humidifResponseData;

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

        ImageButton botonRefresh = findViewById(R.id.botonRefresh);
        botonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ParametrosInvernadero.class);
                startActivityForResult(intent, 0);
            }
        });

        nombre_dispositivo = findViewById(R.id.nombre_dispositivo);
        air_temperature = findViewById(R.id.air_temperature);
        air_humidity = findViewById(R.id.air_humidity);
        ground_humidity = findViewById(R.id.ground_humidity);
        luminosity = findViewById(R.id.luminosity);
        fertilizer_level = findViewById(R.id.fertilizer_level);
        humidif_level = findViewById(R.id.humidif_level);
        extractor = findViewById(R.id.extractor);
        heating = findViewById(R.id.heating);
        leds = findViewById(R.id.leds);
        valve = findViewById(R.id.valve);
        pump = findViewById(R.id.pump);
        humidif = findViewById(R.id.humidif);

        getDeviceData();

        getAirTemperatureData();
        getAirHumidityData();
        getGroundHumidityData();
        getLuminosityData();
        getFertilizerLevelData();
        getHumidifLevelData();

        getLedsData();
        getValveData();
        getPumpData();
        getExtractorData();
        getHeatingData();
        getHumidifData();
    }

    private void getDeviceData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getDevice(new Callback<Device>() {
            @Override
            public void success(Device deviceResponses, Response response) {
                progressDialog.dismiss();
                deviceResponseData = deviceResponses;
                nombre_dispositivo.append(deviceResponseData.getName());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getAirTemperatureData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por avor espere");
        progressDialog.show();

        Api.getClient().getAirTemperature(new Callback<Sensor_Value>() {
            @Override
            public void success(Sensor_Value airTemperatureResponses, Response response) {
                progressDialog.dismiss();
                airTemperatureResponseData = airTemperatureResponses;
                air_temperature.append(airTemperatureResponseData.getValue());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getAirHumidityData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getAirHumidity(new Callback<Sensor_Value>() {
            @Override
            public void success(Sensor_Value airHumidityResponses, Response response) {
                progressDialog.dismiss();
                airHumidityResponseData = airHumidityResponses;
                air_humidity.append(airHumidityResponseData.getValue());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getGroundHumidityData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getGroundHumidity(new Callback<Sensor_Value>() {
            @Override
            public void success(Sensor_Value groundHumidityResponses, Response response) {
                progressDialog.dismiss();
                groundHumidityResponseData = groundHumidityResponses;
                ground_humidity.append(groundHumidityResponseData.getValue());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getLuminosityData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getLuminosity(new Callback<Sensor_Value>() {
            @Override
            public void success(Sensor_Value luminosityResponses, Response response) {
                progressDialog.dismiss();
                luminosityResponseData = luminosityResponses;
                luminosity.append(luminosityResponseData.getValue());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getFertilizerLevelData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getFertilizerLevel(new Callback<Sensor_Value>() {
            @Override
            public void success(Sensor_Value fertilizerLevelResponses, Response response) {
                progressDialog.dismiss();
                fertilizerLevelResponseData = fertilizerLevelResponses;
                fertilizer_level.append(fertilizerLevelResponseData.getValue());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getHumidifLevelData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getHumidifLevel(new Callback<Sensor_Value>() {
            @Override
            public void success(Sensor_Value humidifLevelResponses, Response response) {
                progressDialog.dismiss();
                humidifLevelResponseData = humidifLevelResponses;
                humidif_level.append(humidifLevelResponseData.getValue());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getLedsData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getLeds(new Callback<Actuator_Value>() {
            @Override
            public void success(Actuator_Value ledsResponses, Response response) {
                progressDialog.dismiss();
                ledsResponseData = ledsResponses;
                if(ledsResponseData.getExecution() == 0){
                    leds.append("Off");
                }else{
                    leds.append("On");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getValveData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getValve(new Callback<Actuator_Value>() {
            @Override
            public void success(Actuator_Value valveResponses, Response response) {
                progressDialog.dismiss();
                valveResponseData = valveResponses;
                if(valveResponseData.getExecution() == 0){
                    valve.append("Off");
                }else{
                    valve.append("On");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getPumpData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getPump(new Callback<Actuator_Value>() {
            @Override
            public void success(Actuator_Value pumpResponses, Response response) {
                progressDialog.dismiss();
                pumpResponseData = pumpResponses;
                if(pumpResponseData.getExecution() == 0){
                    pump.append("Off");
                }else{
                    pump.append("On");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getExtractorData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getExtractor(new Callback<Actuator_Value>() {
            @Override
            public void success(Actuator_Value extractorResponses, Response response) {
                progressDialog.dismiss();
                extractorResponseData = extractorResponses;
                if(extractorResponseData.getExecution() == 0){
                    extractor.append("Off");
                }else{
                    extractor.append("On");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getHeatingData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getHeating(new Callback<Actuator_Value>() {
            @Override
            public void success(Actuator_Value heatingResponses, Response response) {
                progressDialog.dismiss();
                heatingResponseData = heatingResponses;
                if(heatingResponseData.getExecution() == 0){
                    heating.append("Off");
                }else{
                    heating.append("On");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void getHumidifData() {
        final ProgressDialog progressDialog = new ProgressDialog(ParametrosInvernadero.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Por favor espere");
        progressDialog.show();

        Api.getClient().getHumidif(new Callback<Actuator_Value>() {
            @Override
            public void success(Actuator_Value humidifResponses, Response response) {
                progressDialog.dismiss();
                humidifResponseData = humidifResponses;
                if(humidifResponseData.getExecution() == 0){
                    humidif.append("Off");
                }else{
                    humidif.append("On");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ParametrosInvernadero.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

}
