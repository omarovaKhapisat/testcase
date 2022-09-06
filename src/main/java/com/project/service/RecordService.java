package com.project.service;

import com.project.dto.RecordDto;
import com.project.exception.DuplicateSubscriberException;
import com.project.exception.NotFoundException;
import com.project.model.Record;
import com.project.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository repository;
    
    public List<Record> getAllRecords() {
        return repository.findAll();
    }
    
    public Record addRecord(RecordDto dto) {
        Record record = Record.builder()
                .subscriberName(dto.getSubscriberName())
                .phoneNumber(dto.getPhoneNumber())
                .lastChanged(LocalDate.now())
                .build();
        
        if (repository.findBySubscriberNameAndPhoneNumber(record.getSubscriberName(), record.getPhoneNumber()).size() > 0) {
            throw new DuplicateSubscriberException(record.getSubscriberName(), record.getPhoneNumber());
        }
        
        return repository.save(record);
    }
    
    public Record editRecord(RecordDto dto) {
        Record recordToChange = repository.findById(dto.getId()).orElseThrow(NotFoundException::new);
        
        recordToChange.setPhoneNumber(dto.getPhoneNumber());
        recordToChange.setSubscriberName(dto.getSubscriberName());
        recordToChange.setLastChanged(LocalDate.now());
    
        return repository.save(recordToChange);
    }
}