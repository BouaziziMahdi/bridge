package com.bridge.bridge.repositories;

import com.bridge.bridge.models.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Integer> {
}
