package com.example.aguela.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aguela.exception.ResourceNotFoundException;
import com.example.aguela.model.Shift;
import com.example.aguela.model.User;
import com.example.aguela.repository.ShiftRepository;
import com.example.aguela.repository.UserRepository;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;
    private final UserRepository userRepository;

    public ShiftService(ShiftRepository shiftRepository, UserRepository userRepository) {
        this.shiftRepository = shiftRepository;
        this.userRepository = userRepository;
    }

    public List<Shift> getShifts(LocalDate start, LocalDate end) {
        return shiftRepository.findByDateBetween(start, end);
    }

    public Shift assignShift(LocalDate date, String type, Long userId) {
        // ✅ Buscar el usuario y lanzamos excepción si no existe
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id " + userId));

        // ✅ Buscar turno existente o crear nuevo
        Shift shift = shiftRepository.findByDateAndType(date, type)
                .orElse(new Shift());

        // ✅ Asignar datos
        shift.setDate(date);
        shift.setType(type);
        shift.setUser(user);

        // ✅ Guardar y devolver
        return shiftRepository.save(shift);
    }
}
