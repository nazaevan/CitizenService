package com.mentoring.project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Table(name= "file", schema = "mentoring")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "id_record", "file_name", "content_type"})
public class FileRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_record")
    @JsonIgnore
    private Long idRecord;

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("content_type")
    private String contentType;

    @JsonProperty("file_size")
    private Long fileSize;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "data")
    @JsonIgnore
    private byte[] data;
}
