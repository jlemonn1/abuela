package com.example.aguela.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aguela.model.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findByDateBetween(LocalDate start, LocalDate end);
    Optional<Shift> findByDateAndType(LocalDate date, String type);
}
