package com.mentoring.project.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name= "request", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "id_status", "id_record", "id_reviewer", "requester_name", "created_at", "updated_at"})
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("id_status")
    private String idStatus;

    @JsonProperty("id_record")
    private Long idRecord;

    @JsonProperty("id_reviewer")
    private Long idReviewer;

    @JsonProperty("requester_name")
    private String requesterName;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
