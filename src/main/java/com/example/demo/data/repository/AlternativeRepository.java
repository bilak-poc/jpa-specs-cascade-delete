package com.example.demo.data.repository;

import com.example.demo.data.entity.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlternativeRepository extends JpaRepository<Alternative, String> {
}
