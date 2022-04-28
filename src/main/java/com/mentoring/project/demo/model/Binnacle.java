package com.mentoring.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Table(name= "binnacle", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Binnacle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_request")
    private Request request;

    private Long idReviewer;

    private String comment;

}