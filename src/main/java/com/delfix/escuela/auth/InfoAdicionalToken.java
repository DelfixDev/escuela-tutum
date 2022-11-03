package com.delfix.escuela.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.delfix.escuela.service.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {
    @Autowired
	private IUsuarioService usuarioService;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        System.out.println(usuarioService.findByUsername(authentication.getName()));
        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Hola que tal!: Fidelmar");
        info.put("nombre", "Fidelmar");
        info.put("apellido", "Cruz");
		info.put("email", "fidelmar.cruzguz@gmail.com");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
    
}
