package com.delfix.escuela.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.delfix.escuela.entity.Calificacion;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO implements Serializable{
    
    private Long id_t_usuario;
    private String nombre; 
    private String apellido;
    private String materia;
    private Float calificacion;
    private String fecha_registro;
    
    public static AlumnoDTO parseCalificacionToAlumnoAPI(Calificacion cali){
        AlumnoDTO alumno = new AlumnoDTO(cali.getAlumno().getIdUsuario(), cali.getAlumno().getNombre(),
                        cali.getAlumno().getApPaterno(), cali.getMateria().getNombre(), cali.getCalifica(), "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        alumno.setFecha_registro(simpleDateFormat.format(cali.getFechaRegistro()));
        return  alumno;
    }
    
}
