package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, String> {
}
