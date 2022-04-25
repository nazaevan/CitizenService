package com.mentoring.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name= "binnacle", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Binnacle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Long idRequest;

    private Long idReviewer;

    private String comment;

}