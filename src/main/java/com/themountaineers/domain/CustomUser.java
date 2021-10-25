package com.themountaineers.domain;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
public class CustomUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private MemberVO member;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		log.info(username + password);
	}

	public CustomUser(MemberVO member) {
		super(member.getMem_id(), member.getMem_pwd(), member.getAuthList().stream().
				map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		log.info(member.getMem_id());
		this.member = member;
	}
}
