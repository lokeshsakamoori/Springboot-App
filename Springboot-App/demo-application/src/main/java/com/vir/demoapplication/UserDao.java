package com.vir.demoapplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	public User retrieveUser( int id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			return null;		

		return user.get();
	}
	
	
	public void deleteUser( int id) {
		userRepository.deleteById(id);
	}
	
	
	public User createUser( User user) {
		User savedUser = userRepository.save(user);

		return user;

	}
	
	
	public List<Post> retrieveAllUsersPost( int id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			return null;
		}
		
		return userOptional.get().getPosts();
	}
	
}
