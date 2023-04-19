package com.crud.demo.auth.core;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

import com.crud.demo.auth.domain.Usuario;


public class AuthUser extends User {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	private String fullName;
	
	public AuthUser(Usuario usuario) {
		super(usuario.getEmail(), usuario.getSenha(),Collections.emptyList());
		
		this.userId = usuario.getId();
		this.fullName = usuario.getNome();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}