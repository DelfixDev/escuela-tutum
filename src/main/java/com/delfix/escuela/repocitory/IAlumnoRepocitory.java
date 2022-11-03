package com.delfix.escuela.repocitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delfix.escuela.entity.Alumno;

@Repository
public interface IAlumnoRepocitory extends CrudRepository<Alumno, Long>{
    
}
