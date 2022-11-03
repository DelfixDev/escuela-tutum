package com.delfix.escuela.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delfix.escuela.dto.AlumnoDTO;
import com.delfix.escuela.dto.CalificacionDTO;
import com.delfix.escuela.service.IEscuelaBo;
import com.delfix.escuela.util.Constants;


@RestController
@RequestMapping("/escuela")
public class EscuelaRestFul {
    @Autowired
    private IEscuelaBo escuelaBo; 

    @GetMapping(produces =MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<AlumnoDTO> getAlumnos(){
        return escuelaBo.createToResponse();
    }
    @PutMapping
    public ResponseEntity<Map<String,String>> putCalificacion(
        @Valid @RequestBody CalificacionDTO calificacionDTO,
        BindingResult result ) {
        if(result.hasErrors()) {
			Map<String, String> response = new HashMap<>();
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
        try{
            return this.reponseAPI(escuelaBo.updateCalificacionById(calificacionDTO.getIdCalificacion(),
                                    Float.valueOf(calificacionDTO.getCalificacion())),
                            "calificacion acrualizada", "No se encontro la calificación");
        } catch (NumberFormatException e) {
            System.err.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    Constants.SUCCESS_RESPONSE, "error",
                    Constants.MSG_RESPONSE, "La informacion proporcinada no es la requerida"));
        }
    }
   
    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteCalificacion(
            @Valid @RequestBody CalificacionDTO calificacionDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> response = new HashMap<>();
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        try {
             return this.reponseAPI(escuelaBo.deleteCalificacionById(calificacionDTO.getIdCalificacion()),
             "calificacion eliminada","No se pudo concretar la transacción");
        } catch (Exception e) {
            System.err.println(e);
            return this.reponseAPI(false, null, "No se pudo concretar la transacción");

        }
    }


    private ResponseEntity<Map<String, String>> reponseAPI(boolean result, String msgOk, String msgErr){
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                        Constants.SUCCESS_RESPONSE , "ok",
                        Constants.MSG_RESPONSE, msgOk));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                        Constants.SUCCESS_RESPONSE, "error",
                        Constants.MSG_RESPONSE, msgErr));
            }
    }
}
