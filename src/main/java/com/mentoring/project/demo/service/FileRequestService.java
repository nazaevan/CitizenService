package com.mentoring.project.demo.service;

import com.mentoring.project.demo.model.FileRequest;
import com.mentoring.project.demo.model.Request;
import com.mentoring.project.demo.repository.FileRequestRepository;
import com.mentoring.project.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;

@Service
public class FileRequestService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private FileRequestRepository repository;

    @Autowired
    private RequestRepository requestRepository;

    public FileRequest createFileRequest(Long idRequest, String filePath, String fileName){


        return transactionTemplate.execute(createRequest -> {
            Optional<Request> request = requestRepository.findById(idRequest);
            Long idRecord;
            FileRequest fileRequest = null;
            if(request.isPresent()){
                Request gottenRequest = request.get();
                fileRequest = new FileRequest();
                fileRequest.setIdRecord(gottenRequest.getRecord().getId());
                fileRequest.setFilePath(filePath);
                fileRequest.setFileName(fileName);
            }
            return repository.save(fileRequest);
        });
    }

}
