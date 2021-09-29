package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;

import java.util.Set;
import java.util.stream.Collectors;

public class BuildingCommandDto {
    private Long id;
    private String name;
    private Double outsideTemperature;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getOutsideTemperature() {
        return outsideTemperature;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

}
