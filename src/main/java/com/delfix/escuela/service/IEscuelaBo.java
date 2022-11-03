package com.delfix.escuela.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.delfix.escuela.dto.AlumnoDTO;

@Service
public interface IEscuelaBo {
    public List<AlumnoDTO> createToResponse();
    public boolean updateCalificacionById(Long id, Float newCalificacion);
    public boolean deleteCalificacionById(Long id);
}
