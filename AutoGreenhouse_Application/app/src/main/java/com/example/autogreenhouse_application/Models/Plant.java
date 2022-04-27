package com.example.autogreenhouse_application.Models;

import com.google.gson.annotations.SerializedName;

public class Plant {

    @SerializedName("id_plant")
    private int id_plant;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("air_temperature")
    private double air_temperature;
    @SerializedName("air_humidity")
    private double air_humidity;
    @SerializedName("ground_humidity")
    private double ground_humidity;

    public Plant() {
    }

    public Plant(int id_plant, String name, String description, double air_temperature, double air_humidity, double ground_humidity) {
        setId_plant(id_plant);
        setName(name);
        setDescription(description);
        setAir_temperature(air_temperature);
        setAir_humidity(air_humidity);
        setGround_humidity(ground_humidity);
    }

    public int getId_plant() {
        return id_plant;
    }

    public void setId_plant(int id_plant) {
        this.id_plant = id_plant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAir_temperature() {
        return air_temperature;
    }

    public void setAir_temperature(double air_temperature) {
        this.air_temperature = air_temperature;
    }

    public double getAir_humidity() {
        return air_humidity;
    }

    public void setAir_humidity(double air_humidity) {
        this.air_humidity = air_humidity;
    }

    public double getGround_humidity() {
        return ground_humidity;
    }

    public void setGround_humidity(double ground_humidity) {
        this.ground_humidity = ground_humidity;
    }
}
