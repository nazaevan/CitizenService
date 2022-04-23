package com.mentoring.project.demo.controller;


import com.mentoring.project.demo.model.Request;
import com.mentoring.project.demo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ms/mentoring-demo/", produces = {(MediaType.APPLICATION_JSON_VALUE)})
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping(value = "request/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Request createRequest (@RequestBody Request requestData) {
        return requestService.createRequest(requestData);
    }
}
