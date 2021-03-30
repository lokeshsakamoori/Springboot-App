package com.vir.demoapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
}
