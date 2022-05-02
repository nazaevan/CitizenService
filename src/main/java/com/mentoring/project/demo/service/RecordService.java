package com.mentoring.project.demo.service;

import com.mentoring.project.demo.model.Record;
import com.mentoring.project.demo.constants.StatusConstants;
import com.mentoring.project.demo.repository.RecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RecordService {
    private static final Logger logger = LoggerFactory.getLogger(RecordService.class);

    @Autowired
    private RecordRepository repository;

    public Record createRecord() {
        Record record = new Record();
        record.setIdStatus(StatusConstants.STATUS_OPENED);

        return repository.save(record);
    }

    @Transactional
    public List<Record> listRecords() {
        return repository.getAllRecords();
    }

}
