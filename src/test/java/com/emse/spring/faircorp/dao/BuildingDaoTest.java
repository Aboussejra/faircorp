package com.emse.spring.faircorp.dao;


import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuildingDaoTest {
    @Autowired
    private BuildingDao buildingDao;

    @Test
    public void shouldFindABuilding() {
        Building building = buildingDao.getById(-10L);
        Assertions.assertThat(building.getName()).isEqualTo("EMSE");
        Assertions.assertThat(building.getOutsideTemperature()).isEqualTo(5.2);
    }

    @Test
    public void shouldFindRoomByName() {
        List<Building> result = buildingDao.findByName("EMSE");
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("name");
    }
}
