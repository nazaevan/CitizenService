package com.mentoring.project.demo.service;

import com.mentoring.project.demo.model.FileRequest;
import com.mentoring.project.demo.model.Request;
import com.mentoring.project.demo.repository.FileRequestRepository;
import com.mentoring.project.demo.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
public class FileRequestService {

    private static final Logger logger = LoggerFactory.getLogger(FileRequestService.class);

    @Autowired
    private FileRequestRepository repository;

    @Autowired
    private RequestRepository requestRepository;

    @Transactional
    public void uploadFile(Long idRequest, MultipartFile file) throws IOException {

        Optional<Request> request = requestRepository.findById(idRequest);
        FileRequest fileRequest = new FileRequest();
        if (request.isPresent()) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            try {
                Request gottenRequest = request.get();
                fileRequest.setIdRecord(gottenRequest.getRecord().getId());
                fileRequest.setData(file.getBytes());
                fileRequest.setFileSize(file.getSize());
                fileRequest.setContentType(file.getContentType());
                fileRequest.setFileName(fileName);

                repository.save(fileRequest);
            } catch (IOException ex) {
                logger.error(String.format("There was a problem uploading the file %s, error: %s", fileName, ex.getMessage()));
                throw ex;
            }
        }
    }

    public Optional<FileRequest> getFile(Long idFile) {
        return repository.findById(idFile);
    }

}
