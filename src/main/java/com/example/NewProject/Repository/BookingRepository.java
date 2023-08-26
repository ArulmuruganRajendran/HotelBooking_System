package com.example.NewProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NewProject.Model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	

}
