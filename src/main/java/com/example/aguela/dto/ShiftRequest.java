package com.example.aguela.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ShiftRequest {
    private LocalDate date;
    private String type;
    private Long userId;
}
