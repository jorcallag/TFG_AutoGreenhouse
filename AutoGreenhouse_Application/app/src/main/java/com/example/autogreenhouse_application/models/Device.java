package com.example.autogreenhouse_application.models;

import com.google.gson.annotations.SerializedName;

public class Device {

    @SerializedName("id_device")
    private int id_device;
    @SerializedName("ip")
    private String ip;
    @SerializedName("name")
    private String name;
    @SerializedName("id_plant_associated")
    private int id_plant_associated;

    public Device() {
    }

    public Device(int id_device, String ip, String name, int id_plant_associated) {
        this.id_device = id_device;
        this.ip = ip;
        this.name = name;
        this.id_plant_associated = id_plant_associated;
    }

    public int getId_device() {
        return id_device;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public int getId_plan_associated() {
        return id_plant_associated;
    }

    public void setId_device(int id_device) {
        this.id_device = id_device;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_plant_associated(int id_plant_associated) {
        this.id_plant_associated = id_plant_associated;
    }
}
