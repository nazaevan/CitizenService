package com.mentoring.project.demo.service;

import com.mentoring.project.demo.constants.GeneralConstants;
import com.mentoring.project.demo.constants.ReviewerConstants;
import com.mentoring.project.demo.constants.StatusConstants;
import com.mentoring.project.demo.model.*;
import com.mentoring.project.demo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    private ReviewerRepository reviewerRepository;

    @Autowired
    private BinnacleRepository binnacleRepository;

    @Autowired
    private FileRequestRepository fileRequestRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @CacheEvict(cacheNames = "requestsList", allEntries = true)
    public Request createRequest(Request request) {

        return transactionTemplate.execute(createRequest -> {
            Optional<Status> status = statusRepository.findById(StatusConstants.STATUS_OPENED);
            status.ifPresent(request::setStatus);

            Optional<Reviewer> reviewer = reviewerRepository.findById(ReviewerConstants.SYSTEM_REVIEWER_ID);
            reviewer.ifPresent(request::setReviewer);

            request.setRecord(new Record());

            request.setCreatedAt(LocalDateTime.now());
            request.setUpdatedAt(LocalDateTime.now());

            Request createdRequest = repository.save(request);

            Binnacle binnacle = new Binnacle();
            binnacle.setIdRequest(createdRequest.getId());
            binnacle.setIdReviewer(ReviewerConstants.SYSTEM_REVIEWER_ID);
            binnacle.setComment(GeneralConstants.DEFAULT_MESSAGE_FOR_BINNACLE+createdRequest.getCreatedAt());
            binnacleRepository.save(binnacle);

            return createdRequest;
        });

    }

    //@Cacheable(cacheNames = "requestsList")
    @Transactional
    public List<Request> listRequests() {
        return repository.getAllRequests();
    }

    public RequestFiles getFilesForRequest(Long id) {
        Optional<Request> request = repository.findById(id);

        if (request.isPresent()) {
            List<FileRequest> files = fileRequestRepository.getAllFiles(request.get().getRecord().getId());

            return new RequestFiles(request.get().getId(), files);
        }

        return new RequestFiles();
    }
}
