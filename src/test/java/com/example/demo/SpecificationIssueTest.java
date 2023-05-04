package com.example.demo;

import com.example.demo.data.entity.Alternative;
import com.example.demo.data.entity.Demand;
import com.example.demo.data.repository.DemandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class SpecificationIssueTest {

    @Autowired
    private DemandRepository demandRepository;

    @Test
    void deleteCascadeWorks() {
        final Demand okDelete = demandWithAlternatives();
        final Demand okDeleteById = demandWithAlternatives();
        final Demand noOkDelete = demandWithAlternatives();

        demandRepository.saveAll(List.of(okDelete, okDeleteById, noOkDelete));

        assertDoesNotThrow(() -> demandRepository.delete(okDelete));
        assertDoesNotThrow(() -> demandRepository.deleteById(okDeleteById.getId()));

        assertDoesNotThrow(() -> demandRepository.delete(DemandRepository.Specs.byId(noOkDelete.getId())));
    }

    private Demand demandWithAlternatives() {
        final Demand demand = new Demand();
        demand.setId(id());
        demand.setAlternatives(List.of(alternative(demand), alternative(demand)));
        return demand;
    }

    private Alternative alternative(final Demand demand) {
        final Alternative alt = new Alternative();
        alt.setId(id());
        alt.setDemand(demand);
        return alt;
    }

    private String id() {
        return UUID.randomUUID().toString();
    }

}
