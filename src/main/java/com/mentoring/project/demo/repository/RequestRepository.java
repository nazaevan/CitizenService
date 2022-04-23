package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
