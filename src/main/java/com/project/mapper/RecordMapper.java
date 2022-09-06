package com.project.mapper;

import com.project.dto.RecordDto;
import com.project.model.Record;

public class RecordMapper {
    
    public static RecordDto recordToDto(Record record) {
        return new RecordDto(record.getSubscriberName(), record.getPhoneNumber(), record.getLastChanged(), record.getId());
    }
}
