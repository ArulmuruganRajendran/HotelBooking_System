package com.example.NewProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NewProject.Model.UserDetails;
@Repository
public interface UserDetailsRepository  extends JpaRepository<UserDetails, Integer>{
	

}
