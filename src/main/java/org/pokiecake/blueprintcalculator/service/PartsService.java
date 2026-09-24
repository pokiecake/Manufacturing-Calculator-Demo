package org.pokiecake.blueprintcalculator.service;

import org.pokiecake.blueprintcalculator.entity.Part;

import java.util.List;

public interface PartsService {

    List<Part> getAllParts();

    List<Part> getAllPartsFrom(String companyName);

    Part getPartById(int id);
}
