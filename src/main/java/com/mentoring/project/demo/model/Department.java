package com.mentoring.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "department", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    private Long id;

    private String description;

}
