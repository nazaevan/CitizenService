package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, String> {
}
