package com.delfix.escuela.repocitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delfix.escuela.entity.Calificacion;

@Repository
public interface ICalificasionesRepository extends CrudRepository<Calificacion, Long> {
    
}
