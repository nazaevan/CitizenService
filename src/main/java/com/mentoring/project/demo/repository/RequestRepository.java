package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("select r from Request r LEFT JOIN FETCH r.binnacles where r.id=:id")
    Request getById(@Param("id") Long id);

    @Query("select r from Request r LEFT JOIN FETCH r.binnacles")
    List<Request> getAllRequests();
}
