package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
}
