package com.mentoring.project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name= "request", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "status", "record", "id_reviewer", "requester_name", "created_at", "updated_at"})
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_record", referencedColumnName = "id", nullable = false)
    private Record record;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_reviewer", referencedColumnName = "id", nullable = false)
    private Reviewer reviewer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_request", referencedColumnName = "id")
    private List<Binnacle> binnacles = new ArrayList<>();;

    @JsonProperty("requester_name")
    private String requesterName;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
