package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.Binnacle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BinnacleRepository extends JpaRepository<Binnacle, Long> {
}
