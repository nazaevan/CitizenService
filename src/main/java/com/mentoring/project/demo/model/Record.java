package com.mentoring.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "record", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    private String id;

    private String idStatus;

    private Boolean isPublic;
}
