package com.delfix.escuela.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CalificacionDTO implements Serializable{
    @NotNull(message="El valor no puede ser vacio")
    private Long idCalificacion;
    @Pattern(regexp="^(10|\\d)(\\.\\d{1,2})?$", message="El formato no es el solicitado")
    @NotEmpty(message="El valor no puede ser vacio")
    private String calificacion;
}
