package com.mentoring.project.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id_request", "files"})
public class RequestFiles {

    @JsonProperty("id_request")
    private Long idRequest;

    @JsonProperty("files")
    private List<FileRequest> files;

}
