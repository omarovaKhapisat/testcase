package com.project.controller;

import com.project.dto.RecordDto;
import com.project.mapper.RecordMapper;
import com.project.model.Record;
import com.project.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.project.mapper.RecordMapper.recordToDto;

@Valid
@RestController
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;
    
    @GetMapping("/getRecords")
    public List<RecordDto> getRecords() {
        return recordService.getAllRecords().stream()
                .map(RecordMapper::recordToDto)
                .collect(Collectors.toList());
    }
    
    @PostMapping("/addRecord")
    public RecordDto addRecord(@RequestBody @Valid RecordDto recordDto) {
        return recordToDto(recordService.addRecord(recordDto));
    }
    
    @PatchMapping("/editRecord")
    public RecordDto editRecord(@RequestBody @Valid RecordDto recordDto) {
        return recordToDto(recordService.editRecord(recordDto));
    }
}
