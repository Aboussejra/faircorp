package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findByName(String name){
        String jpql = "select r from Room r where r.name = :name";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", name)
                .getResultList();
    }
    @Transactional
    @Modifying
    public List<Room> deleteAllRoomsInBuilding(Long id) {
        String jpql = "delete from Room r where r.building.id = :id";
        em.createQuery(jpql).setParameter("id", id).executeUpdate();
        String jpql1 = " select r from Room r where r.building.id = :id";
        return em.createQuery(jpql1, Room.class)
                .setParameter("id", id)
                .getResultList();
    }
}
