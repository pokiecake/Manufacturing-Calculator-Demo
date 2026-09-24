package org.pokiecake.blueprintcalculator.dao;

import org.pokiecake.blueprintcalculator.entity.Part;

import java.util.List;

public interface PartDao {

    List<Part> getAllParts();

    List<Part> getAllPartsFrom(String companyName);

    Part getPartById(int id);

}
