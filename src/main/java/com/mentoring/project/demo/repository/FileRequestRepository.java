package com.mentoring.project.demo.repository;

import com.mentoring.project.demo.model.FileRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRequestRepository extends JpaRepository<FileRequest, Long> {
}
