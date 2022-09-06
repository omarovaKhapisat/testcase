package com.project.repository;

import com.project.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    
    List<Record> findBySubscriberNameAndPhoneNumber(String name, String phoneNumber);
}