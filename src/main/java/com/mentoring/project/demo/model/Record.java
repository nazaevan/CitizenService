package com.mentoring.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Table(name= "record", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idStatus;

    @ColumnDefault("false")
    private Boolean isPublic;
}
