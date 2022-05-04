package com.example.autogreenhouse_application.models;

import com.google.gson.annotations.SerializedName;

public class Sensor {

    @SerializedName("id_sensor")
    private int id_sensor;
    @SerializedName("type")
    private String type;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("id_device_associated")
    private int id_device_associated;

    public Sensor(){

    }

    public Sensor(int id_sensor, String type, String name, String description, int id_device_associated){
        setId_sensor(id_sensor);
        setType(type);
        setName(name);
        setDescription(description);
        setId_device_associated(id_device_associated);
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getId_device_associated() {
        return id_device_associated;
    }

    public void setId_device_associated(int id_device_associated) {
        this.id_device_associated = id_device_associated;
    }
}
