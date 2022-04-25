package com.mentoring.project.demo.service;

import com.mentoring.project.demo.model.Request;
import com.mentoring.project.demo.model.Record;
import com.mentoring.project.demo.constants.Status;
import com.mentoring.project.demo.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;

@Service
public class RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestRepository repository;

    @Autowired
    private RecordService recordService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public Request createRequest(Request request) {

        return transactionTemplate.execute(createRequest -> {
            Record createdRecord = recordService.createRecord();
            request.setIdStatus(Status.STATUS_OPENED);
            request.setIdRecord(createdRecord.getId());
            request.setCreatedAt(LocalDateTime.now());
            request.setUpdatedAt(LocalDateTime.now());

            return repository.save(request);
        });

    }
}
