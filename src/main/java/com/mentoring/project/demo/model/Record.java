package com.mentoring.project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mentoring.project.demo.constants.StatusConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name= "record", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "id_status", "is_public"})
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("id_status")
    private String idStatus = StatusConstants.STATUS_OPENED;

    @JsonProperty("id_public")
    private Boolean isPublic = Boolean.FALSE;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_record", referencedColumnName = "id")
    @JsonIgnore
    private List<FileRequest> files = new ArrayList<>();
}
