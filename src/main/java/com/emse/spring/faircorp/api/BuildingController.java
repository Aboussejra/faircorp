package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
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
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final BuildingDao buildingDao;

    public BuildingController(RoomDao roomDao, HeaterDao heaterDao, WindowDao windowDao, BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.buildingDao = buildingDao;
    };

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }
    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteBuilding(@PathVariable Long id) {
        heaterDao.deleteAllHeatersInRoom(id);
        windowDao.deleteAllWindowsInBuilding(id);
        roomDao.deleteAllRoomsInBuilding(id);
        buildingDao.deleteById(id);
    }
    @PostMapping
    public BuildingDto create(@RequestBody BuildingCommandDto dto) {
        Building building = buildingDao.save(new Building(dto.getName(), dto.getOutsideTemperature()));
        return new BuildingDto(building);
    }

}