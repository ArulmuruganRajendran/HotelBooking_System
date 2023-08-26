package com.example.NewProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NewProject.Model.UserDetails;
import com.example.NewProject.Model.UserNotFoundException;
import com.example.NewProject.Repository.UserDetailsRepository;

@Service
public class UserDetailsService {
	@Autowired
	UserDetailsRepository userRep;

	public List<UserDetails> getUser() throws UserNotFoundException {
		List<UserDetails> userSer = userRep.findAll();
		if (userSer.isEmpty()) {
			throw new UserNotFoundException("empty database");
		} else {
			return userSer;

		}
	}

	public Optional<UserDetails> getUserById(int id) throws UserNotFoundException {
		Optional<UserDetails> userser = userRep.findById(id);
		if (userser.isEmpty()) {
			throw new UserNotFoundException("User not found in database");
		} else {
			return userser;
		}
	}

	public UserDetails addUser(UserDetails userDet) {
		UserDetails users=userRep.save(userDet);
		return users;
	}

	public void upDateUser(UserDetails userDet, int id) throws UserNotFoundException {
		Optional<UserDetails> user = userRep.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("user not found ");

		} else {
			UserDetails user1 = user.get();
			user1.setId(user1.getId());
			user1.setUsername(user1.getUsername());
			user1.setPassword(user1.getPassword());
			user1.setEmail(user1.getEmail());
			user1.setRole(user1.getRole());
			userRep.save(user1);

		}

	}

	public void deleteUser(int id) throws UserNotFoundException {
		Optional<UserDetails> user = userRep.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("invalid id ");
		} else {
			userRep.deleteById(id);
		}

	}

}
