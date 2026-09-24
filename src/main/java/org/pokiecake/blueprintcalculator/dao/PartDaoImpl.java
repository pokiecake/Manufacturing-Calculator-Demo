package org.pokiecake.blueprintcalculator.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pokiecake.blueprintcalculator.entity.Part;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartDaoImpl implements PartDao {
    EntityManager entityManager;

    public PartDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Part> getAllParts() {
        TypedQuery<Part> query = entityManager.createQuery("from Part", Part.class);
        return query.getResultList();
    }

    @Override
    public List<Part> getAllPartsFrom(String companyName) {
        return List.of();
    }

    @Override
    public Part getPartById(int id) {
        return entityManager.find(Part.class, id);
    }

}
