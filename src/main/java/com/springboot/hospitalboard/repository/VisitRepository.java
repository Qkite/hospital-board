package com.springboot.hospitalboard.repository;

import com.springboot.hospitalboard.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
