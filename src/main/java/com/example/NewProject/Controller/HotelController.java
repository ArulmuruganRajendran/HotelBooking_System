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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.NewProject.Model.Hotel;
import com.example.NewProject.Model.HotelNotFoundException;
import com.example.NewProject.Service.HotelService;

@RestController
@RequestMapping("/Hotels")
public class HotelController {
	@Autowired
	HotelService hotelSer;

	@GetMapping
	public List<Hotel> getHotel() throws HotelNotFoundException {
		List<Hotel> hotelCon = hotelSer.getHotel();
		return hotelCon;
	}

	@GetMapping("/{id}")
	public Optional<Hotel> getHotelById(@PathVariable int id) throws HotelNotFoundException {
		Optional<Hotel> hotelCon = hotelSer.getHotelById(id);
		return hotelCon;

	}

	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		hotelSer.addHotel(hotel);
		return new ResponseEntity<>(hotel, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public HttpStatus upDateHotel(@RequestBody Hotel hotel, @PathVariable int id) throws HotelNotFoundException {
		hotelSer.upDateHotel(hotel, id);
		return HttpStatus.OK;

	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteHotel(@PathVariable int id) throws HotelNotFoundException {
		hotelSer.deleteHotel(id);
		return HttpStatus.OK;

	}

	@GetMapping("/search")

	public List<Hotel> searchHotels(@RequestParam String location, @RequestParam int rating) {
		return hotelSer.getHotelsByLocationAndRating(location, rating);
	}

}
