package com.example.aguela.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aguela.dto.ShiftRequest;
import com.example.aguela.model.Shift;
import com.example.aguela.service.ShiftService;

@RestController
@RequestMapping("/api/shifts")
@CrossOrigin(origins = "*")
public class ShiftController {

    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping
    public List<Shift> getShifts(
        @RequestParam LocalDate start,
        @RequestParam LocalDate end
    ) {
        return shiftService.getShifts(start, end);
    }

    @PostMapping
    public Shift assignShift(@RequestBody ShiftRequest request) {
        return shiftService.assignShift(request.getDate(), request.getType(), request.getUserId());
    }
}
