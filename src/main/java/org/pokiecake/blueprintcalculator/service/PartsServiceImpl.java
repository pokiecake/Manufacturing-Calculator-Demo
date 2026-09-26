package org.pokiecake.blueprintcalculator.service;

import org.pokiecake.blueprintcalculator.dao.PartDao;
import org.pokiecake.blueprintcalculator.entity.Part;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService{
    PartDao partDao;

    public PartsServiceImpl(PartDao partDao) {
        this.partDao = partDao;
    }

    @Override
    public List<Part> getAllParts() {
        return partDao.getAllParts();
    }

    @Override
    public List<Part> getAllPartsFrom(String companyName) {
        return partDao.getAllPartsFrom(companyName);
    }

    @Override
    public Part getPartById(int id) {
        return partDao.getPartById(id);
    }

    @Override
    public Part getCheapestParts() {
        List<Part> allParts = getAllParts();

        Part cheapestPart = allParts.getFirst();
        for (Part part : allParts) {

        }


        return null;
    }
}
