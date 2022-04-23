package com.mentoring.project.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name= "reviewer", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviewer {
    @Id
    private Long id;

    private String name;

    private String lastName;

    private Long idDepartment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
