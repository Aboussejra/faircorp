package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class BuildingDto {
    private Long id;
    private String name;
    private Double outsideTemperature;
    private Set<RoomDto> rooms;
    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.outsideTemperature = building.getOutsideTemperature();
        this.rooms = building.getRooms().stream().map(RoomDto::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setRooms(Set<RoomDto> rooms) {
        this.rooms = rooms;
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

    public Set<RoomDto> getRooms() {
        return rooms;
    }

}
