package com.example.autogreenhouse_application.models;

import com.google.gson.annotations.SerializedName;

public class Actuator {

    @SerializedName("id_actuator")
    private int id_actuator;
    @SerializedName("type")
    private String type;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("id_device_associated")
    private int id_device_associated;

    public Actuator(){

    }

    public Actuator(int id_actuator, String type, String name, String description, int id_device_associated) {
        setId_actuator(id_actuator);
        setType(type);
        setName(name);
        setDescription(description);
        setId_device_associated(id_device_associated);
    }

    public int getId_actuator() {
        return id_actuator;
    }

    public void setId_actuator(int id_actuator) {
        this.id_actuator = id_actuator;
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

