package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.model.*;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;

    public RoomController(RoomDao roomDao, HeaterDao heaterDao, WindowDao windowDao) {
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getName(), dto.getFloor()));
        }
        else {
            room = roomDao.getById(dto.getId());
            room.setFloor(dto.getFloor());
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteHeaters(@PathVariable Long id) {
        heaterDao.deleteAllHeatersInRoom(id);
        windowDao.deleteAllWindowsInRoom(id);
        roomDao.deleteById(id);
    }


    @PutMapping(path = "/{id}/switchWindow")
    public List<WindowDto> switchWindow(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        Set<Window> windows = room.getWindows();
        for(Window window : windows) {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
        }
        return room.getWindows().stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public List<HeaterDto> switchHeater(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        Set<Heater> heaters = room.getHeaters();
        for(Heater heater : heaters) {
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        }
        return room.getHeaters().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

}
