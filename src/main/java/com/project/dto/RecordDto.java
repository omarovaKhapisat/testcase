package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {
    @NotEmpty
    private String subscriberName;
    @NotEmpty
    private String phoneNumber;
    private LocalDate lastChanged;
    @NotNull
    private Long id = -1L;
    
}
