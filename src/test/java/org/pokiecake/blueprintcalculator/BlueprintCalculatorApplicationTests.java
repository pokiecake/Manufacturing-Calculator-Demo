package org.pokiecake.blueprintcalculator;

import org.junit.jupiter.api.Test;
import org.pokiecake.blueprintcalculator.dao.PartDao;
import org.pokiecake.blueprintcalculator.entity.Part;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlueprintCalculatorApplicationTests {
    PartDao partDao;

    public BlueprintCalculatorApplicationTests(PartDao partDao) {
        this.partDao = partDao;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void partByIdTest() {
        Part part = partDao.getPartById(1);
        assert(part.getPartName().equals("23' wheel"));

    }
}
