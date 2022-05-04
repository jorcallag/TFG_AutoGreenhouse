package com.example.autogreenhouse_application.api;

import com.example.autogreenhouse_application.models.Actuator_Value;
import com.example.autogreenhouse_application.models.Device;
import com.example.autogreenhouse_application.models.Plant;
import com.example.autogreenhouse_application.models.Sensor_Value;


import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.PUT;

public interface ApiInterface {

    //Info planta
    @GET("/api/Get/Plant/Id/1")
    public void getPlant(Callback<Plant> callback);

    //Info sensor temperatura aire
    @GET("/api/Get/SensorValue/BySensor/Id/1")
    public void getAirTemperature(Callback<Sensor_Value> callback);

    //Info sensor humedad aire
    @GET("/api/Get/SensorValue/BySensor/Id/2")
    public void getAirHumidity(Callback<Sensor_Value> callback);

    //Info sensor humedad tierra
    @GET("/api/Get/SensorValue/BySensor/Id/3")
    public void getGroundHumidity(Callback<Sensor_Value> callback);

    //Info sensor luminosidad
    @GET("/api/Get/SensorValue/BySensor/Id/4")
    public void getLuminosity(Callback<Sensor_Value> callback);

    //Info sensor nivel fertilizante
    @GET("/api/Get/SensorValue/BySensor/Id/5")
    public void getFertilizerLevel(Callback<Sensor_Value> callback);

    //Info sensor nivel humidificador
    @GET("/api/Get/SensorValue/BySensor/Id/6")
    public void getHumidifLevel(Callback<Sensor_Value> callback);

    //Info actuador leds
    @GET("/api/Get/SensorValue/BySensor/Id/1")
    public void getLeds(Callback<Actuator_Value> callback);

    //Info actuador electrovalvula
    @GET("/api/Get/SensorValue/BySensor/Id/2")
    public void getValve(Callback<Actuator_Value> callback);

    //Info actuador bomba
    @GET("/api/Get/SensorValue/BySensor/Id/3")
    public void getPump(Callback<Actuator_Value> callback);

    //Info actuador extractor
    @GET("/api/Get/SensorValue/BySensor/Id/4")
    public void getExtractor(Callback<Actuator_Value> callback);

    //Info actuador calefactor
    @GET("/api/Get/SensorValue/BySensor/Id/5")
    public void getHeating(Callback<Actuator_Value> callback);

    //Info actuador humidificador
    @GET("/api/Get/SensorValue/BySensor/Id/6")
    public void getHumidif(Callback<Actuator_Value> callback);

    //Info dispositivo
    @GET("/api/Get/Device/Id/1")
    public void getDevice(Callback<Device> callback);

    @FormUrlEncoded
    @PUT("/api/Put/Plant/Id/1")
    public void registration(@Field("name") String name,
                             @Field("description") String description,
                             @Field("air_temperature") double air_temperature,
                             @Field("air_humidity") double air_humidity,
                             @Field("ground_humidity") double ground_humidity,
                             @Field("quantity_fertilizer_week") double quantity_fertilizer_week,
                             Callback<Plant> callback);

}
