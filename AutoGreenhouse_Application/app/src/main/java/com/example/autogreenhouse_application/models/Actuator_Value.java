package com.example.autogreenhouse_application.models;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;

public class Actuator_Value {

    @SerializedName("id_actuator_value")
    private int id_actuator_value;
    @SerializedName("execution")
    private int execution;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("id_actuator_associated")
    private int id_actuator_associated;

    public Actuator_Value(){

    }

    public Actuator_Value(int id_actuator_value, int execution, String timestamp, int id_actuator_associated){
        setId_actuator_value(id_actuator_value);
        setExecution(execution);
        setTimestamp(timestamp);
        setId_actuator_associated(id_actuator_associated);
    }

    public int getId_actuator_value() {
        return id_actuator_value;
    }

    public void setId_actuator_value(int id_actuator_value) {
        this.id_actuator_value = id_actuator_value;
    }

    public int getExecution() {
        return execution;
    }

    public void setExecution(int execution) {
        this.execution = execution;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getId_actuator_associated() {
        return id_actuator_associated;
    }

    public void setId_actuator_associated(int id_actuator_associated) {
        this.id_actuator_associated = id_actuator_associated;
    }
}
