package com.delfix.escuela.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "t_calificaciones")
public class Calificacion implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private Long idCalificacion;
    @Column(name = "calificacion")
    private Float califica;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
   
    @OneToOne
    @JoinColumn(name="id_t_materias",nullable=false)
    private Materia materia;
    @OneToOne
    @JoinColumn(name = "id_t_usuarios", nullable = false)
    private Alumno alumno;
  
}
