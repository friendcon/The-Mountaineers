package com.themountaineers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.themountaineers.domain.CustomUser;
import com.themountaineers.domain.MemberVO;
import com.themountaineers.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailService implements UserDetailsService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("********** User Detail Service ********** : " + username);
		log.info("********** User Name ********** : " + username);
		MemberVO member = mapper.memberRead(username);
		log.info(member);
		
		return member == null ? null : new CustomUser(member);
	}

}
