package com.example.autogreenhouse_application.models;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;

public class Sensor_Value {

    @SerializedName("id_sensor_value")
    private int id_sensor_value;
    @SerializedName("value")
    private String value;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("id_sensor_associated")
    private int id_sensor_associated;

    public Sensor_Value(){

    }

    public Sensor_Value(int id_sensor_value, String value, String timestamp, int id_sensor_associated){
        setId_sensor_value(id_sensor_value);
        setValue(value);
        setTimestamp(timestamp);
        setId_sensor_associated(id_sensor_associated);
    }

    public int getId_sensor_value() {
        return id_sensor_value;
    }

    public void setId_sensor_value(int id_sensor_value) {
        this.id_sensor_value = id_sensor_value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getId_sensor_associated() {
        return id_sensor_associated;
    }

    public void setId_sensor_associated(int id_sensor_associated) {
        this.id_sensor_associated = id_sensor_associated;
    }
}
