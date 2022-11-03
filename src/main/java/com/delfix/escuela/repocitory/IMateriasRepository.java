package com.delfix.escuela.repocitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delfix.escuela.entity.Materia;

@Repository

public interface IMateriasRepository extends CrudRepository<Materia, Long>{
    
}
