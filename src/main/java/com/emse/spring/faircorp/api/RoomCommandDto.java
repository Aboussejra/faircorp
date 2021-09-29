package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class RoomCommandDto {
    private Integer floor;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;
    private Long buildingId;


    public Integer getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Long getBuildingId() {return this.buildingId;}
    public void setBuildingId(Long buildingId) {this.buildingId = buildingId;}


}
