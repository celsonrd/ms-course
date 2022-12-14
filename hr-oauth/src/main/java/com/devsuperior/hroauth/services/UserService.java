package com.devsuperior.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(User.class);

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User fidnByEmail(String email) {
		
		User user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found" + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found" + email);
		return user;
	}
}
