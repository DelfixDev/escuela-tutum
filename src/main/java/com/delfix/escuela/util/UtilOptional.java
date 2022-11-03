package com.delfix.escuela.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UtilOptional<T> {
    public  T get(Optional<T> optional) {
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}   
}
