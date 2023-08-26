package com.example.NewProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NewProject.Model.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
	List<Hotel> findByLocationAndRating(String location, int rating);

}
