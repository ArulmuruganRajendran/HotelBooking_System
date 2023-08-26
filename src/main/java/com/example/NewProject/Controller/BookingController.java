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

import com.example.NewProject.Model.Booking;
import com.example.NewProject.Model.BookingNotFoundException;
import com.example.NewProject.Service.BookingSer;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingSer bookingSer;
	
	@GetMapping
	public List<Booking> getBooking() throws BookingNotFoundException{
		List<Booking>bookingCon=bookingSer.getBookingr();
		return bookingCon;
		
	}
	@GetMapping("/{id}")
	public Optional<Booking> getBookingById(@PathVariable int id) throws BookingNotFoundException{
		Optional<Booking>bookingCon = bookingSer.getBookingById(id);
		return bookingCon;
		
	}
	@PostMapping
	public ResponseEntity<Booking> addBooking(@RequestBody Booking bookingCon){
		bookingSer.addBooking(bookingCon);
		return new ResponseEntity<Booking>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}") 
	public HttpStatus upDateBooking(@RequestBody Booking bookingCon ,@PathVariable int id) throws BookingNotFoundException{
		bookingSer.upDateBooking(bookingCon,id);
		return HttpStatus.OK;
		
	}
	@DeleteMapping("/{id}")
	public HttpStatus deleteBooking(@PathVariable int id) throws BookingNotFoundException {
		bookingSer.deleteBooking(id);
		return HttpStatus.OK;
		
	}

}
