package com.mentoring.project.demo.controller;


import com.mentoring.project.demo.model.Request;
import com.mentoring.project.demo.model.RequestFiles;
import com.mentoring.project.demo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ms/mentoring-demo/", produces = {(MediaType.APPLICATION_JSON_VALUE)})
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping(value = "request/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Request createRequest (@RequestBody Request requestData) {
        return requestService.createRequest(requestData);
    }

    @GetMapping(value = "request/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Request> listRequests () {
        return requestService.listRequests();
    }

    @GetMapping(value = "request/file", produces = MediaType.APPLICATION_JSON_VALUE)
    public RequestFiles listRequestWithFiles (@RequestParam("id_request") Long idRequest) {
        return requestService.getFilesForRequest(idRequest);
    }

    @PostMapping(value = "request/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Request updateRequest (@RequestBody Request requestData) {
        return requestService.updateRequest(requestData);
    }
}
