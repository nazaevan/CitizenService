package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.FileRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileRequestRepository extends JpaRepository<FileRequest, Long> {

    @Query("select f from FileRequest f where f.idRecord=:idRecord")
    List<FileRequest> getAllFiles(@Param("idRecord") Long idRecord);
}
