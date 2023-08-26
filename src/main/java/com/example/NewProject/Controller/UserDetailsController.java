package com.example.NewProject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NewProject.Model.UserDetails;
import com.example.NewProject.Model.UserNotFoundException;
import com.example.NewProject.Service.UserDetailsService;

@RestController
@RequestMapping("/users")
public class UserDetailsController {
	@Autowired
	UserDetailsService userSer;

	@GetMapping
	public List<UserDetails> getUser() throws UserNotFoundException {
		List<UserDetails> userCon = userSer.getUser();
		return userCon;

	}

	@GetMapping("/{id}")
	public Optional<UserDetails> getUserById(@PathVariable int id) throws UserNotFoundException {
		Optional<UserDetails> userCon = userSer.getUserById(id);
		return userCon;
	}

	@PostMapping
	public ResponseEntity<UserDetails> addEmployee(@RequestBody UserDetails userCon) {
		UserDetails users=userSer.addUser(userCon);
		return new ResponseEntity<UserDetails>(users,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public HttpStatus upDateUser(@RequestBody UserDetails userCon, @PathVariable int id)
			throws UserNotFoundException {
		userSer.upDateUser(userCon, id);
		return HttpStatus.OK;
	}
	@DeleteMapping("/{id}")
	public HttpStatus deleteUser(@PathVariable int id) throws UserNotFoundException {
		userSer.deleteUser(id);

		return HttpStatus.OK;

	}

}
