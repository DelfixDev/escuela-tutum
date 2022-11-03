package com.delfix.escuela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delfix.escuela.dto.AlumnoDTO;
import com.delfix.escuela.entity.Calificacion;
import com.delfix.escuela.repocitory.ICalificasionesRepository;
import com.delfix.escuela.util.UtilOptional;

@Service
public class EscuelaBoImp implements IEscuelaBo{
    @Autowired
    private ICalificasionesRepository iCalifica;
    @Autowired
    private UtilOptional<Calificacion> util;
    @Transactional(readOnly = true)
    @Override
    public List<AlumnoDTO> createToResponse() {
        List<Calificacion> calificacions = (List<Calificacion>) iCalifica.findAll();
        List<AlumnoDTO> alumnoAPIs = new ArrayList<>();
        calificacions.stream().forEach(c-> alumnoAPIs.add(AlumnoDTO.parseCalificacionToAlumnoAPI(c)));
        return alumnoAPIs;
    }
    @Transactional
    @Override
    public boolean updateCalificacionById(Long id, Float newCalificacion) {
        try{
            Calificacion newCalifi = util.get(iCalifica.findById(id));
            if(Objects.isNull(newCalifi)){
                return false;
            }
            newCalifi.setCalifica(newCalificacion);
            iCalifica.save(newCalifi);
        }catch(DataAccessException e){
            System.err.println(e);
            return false;
        }
        return true;
    }
    @Transactional
    @Override
    public boolean deleteCalificacionById(Long id) {
        if(Objects.isNull(id)){
            return false;
        }
        Calificacion c = new Calificacion();
        c.setIdCalificacion(id);
        try {
            iCalifica.delete(c);
            return true;
        } catch (DataAccessException e) {
            System.err.println(e);
            return false;
        }
    }
    
}
