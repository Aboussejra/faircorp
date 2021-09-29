package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable=false)
    private String name;

    private Double currentTemperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private Set<Window> windows;

    private Double targetTemperature;

    @ManyToOne(optional = false)
    private Building building;

    public Room() {
    }
    public  Room(String name, Integer floor, Building building){
        this.name = name;
        this.floor = floor;
        this.building = building;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() { return this.floor;}

    public void setFloor(Integer floor) { this.floor = floor;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
    public Double getCurrentTemperature() {
        return currentTemperature;
    }
    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public Set<Heater> getHeaters() {
        return this.heaters;
    }
    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }
    public Set<Window> getWindows() {
        return this.windows;
    }
    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }
    public Building getBuilding() {return this.building;}
    public void setBuilding(Building building) {this.building = building;}

}
