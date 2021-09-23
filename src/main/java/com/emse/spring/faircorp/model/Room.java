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

    @Column(nullable = true)
    private Double currentTemperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private Set<Window> windows;

    @Column(nullable = true)
    private Double targetTemperature;

    public Room() {
    }
    public  Room(Long id, Integer floor, String name, Double currentTemperature, Double targetTemperature, Set<Heater> heaters, Set<Window> windows){
        this.id = id;
        this.floor = floor;
        this.name = name;
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

}
