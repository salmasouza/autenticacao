package com.crud.demo.auth.core;

import java.util.HashMap;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class JwtCustomClaimsTokenEnhancer implements TokenEnhancer{

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		var authUser = (AuthUser) authentication.getPrincipal();
		var info = new HashMap<String, Object>();
		
		info.put("nome_completo", authUser.getFullName());
		
		var oAuth2AccessToken = (DefaultOAuth2AccessToken) accessToken;
		oAuth2AccessToken.setAdditionalInformation(info);
		info.put("usuario_id", authUser.getUsername());
		
		return accessToken;
	}
	
	

}
