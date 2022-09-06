package com.project.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PhoneBook")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Record {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String subscriberName;
    @Column
    private String phoneNumber;
    @Column
    private LocalDate lastChanged;
    
}