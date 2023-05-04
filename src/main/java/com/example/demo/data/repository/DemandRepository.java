package com.example.demo.data.repository;

import com.example.demo.data.entity.Demand;
import com.example.demo.data.entity.Demand_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemandRepository extends JpaRepository<Demand, String>, JpaSpecificationExecutor<Demand> {

    interface Specs {

        static Specification<Demand> byId(final String id) {
            return (root, query, cb) -> cb.equal(root.get(Demand_.id), id);
        }
    }
}
