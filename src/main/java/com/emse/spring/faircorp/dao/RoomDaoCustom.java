package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findByName(String name);
    List<Room> deleteAllRoomsInBuilding(Long id);
}
