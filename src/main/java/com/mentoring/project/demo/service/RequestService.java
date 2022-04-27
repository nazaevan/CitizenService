package com.mentoring.project.demo.service;

import com.mentoring.project.demo.constants.StatusConstants;
import com.mentoring.project.demo.model.Record;
import com.mentoring.project.demo.model.Request;
import com.mentoring.project.demo.model.Status;
import com.mentoring.project.demo.repository.RequestRepository;
import com.mentoring.project.demo.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestRepository repository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @CacheEvict(cacheNames = "requestsList", allEntries = true)
    public Request createRequest(Request request) {

        return transactionTemplate.execute(createRequest -> {
            Optional<Status> status = statusRepository.findById(StatusConstants.STATUS_OPENED);
            status.ifPresent(request::setStatus);

            request.setRecord(new Record());
            request.setCreatedAt(LocalDateTime.now());
            request.setUpdatedAt(LocalDateTime.now());

            return repository.save(request);
        });

    }

    @Cacheable(cacheNames = "requestsList")
    public List<Request> listRequests() {
        return transactionTemplate.execute(listRequests -> repository.findAll());

    }
}
