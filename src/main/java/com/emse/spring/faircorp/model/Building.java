package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "BUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable = false)
    private Double outsideTemperature;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    public Building() {
    }
    public  Building(String name, Double outsideTemperature){
        this.name = name;
        this.outsideTemperature = outsideTemperature;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }
    public Double getOutsideTemperature() {
        return outsideTemperature;
    }

    public Set<Room> getRooms() {
        return this.rooms;
    }
    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

}
