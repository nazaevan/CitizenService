package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("select r from Record r LEFT JOIN FETCH r.files where r.id=:id")
    Record getById(@Param("id") Long id);

    @Query("select r from Record r LEFT JOIN FETCH r.files")
    List<Record> getAllRecord();
}
