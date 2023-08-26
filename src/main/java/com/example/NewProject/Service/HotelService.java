package com.example.NewProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NewProject.Model.Hotel;
import com.example.NewProject.Model.HotelNotFoundException;
import com.example.NewProject.Repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	HotelRepository hotelRep;

	public List<Hotel> getHotel() throws HotelNotFoundException {
		List<Hotel> hotelSer = hotelRep.findAll();
		if (hotelSer.isEmpty()) {
			throw new HotelNotFoundException("hotel not found");
		} else {
			return hotelSer;
		}
	}

	public Optional<Hotel> getHotelById(int id) throws HotelNotFoundException {
		Optional<Hotel> hotelSer = hotelRep.findById(id);
		if (hotelSer.isEmpty()) {
			throw new HotelNotFoundException("Id is not found ");
		} else {
			return hotelSer;
		}
	}

	public void addHotel(Hotel hotel) {
		hotelRep.save(hotel);
	}

	public void upDateHotel(Hotel newHotel, int id) throws HotelNotFoundException {
	    Optional<Hotel> hotelSer = hotelRep.findById(id);
	    if (hotelSer.isEmpty()) {
	        throw new HotelNotFoundException("Id not Found ");
	    } else {
	        Hotel existingHotel = hotelSer.get();
	        existingHotel.setName(newHotel.getName());
	        existingHotel.setAddress(newHotel.getAddress());
	        existingHotel.setPhoneNumber(newHotel.getPhoneNumber());
	        existingHotel.setLocation(newHotel.getLocation());
	        existingHotel.setRating(newHotel.getRating());
	        hotelRep.save(existingHotel);
	    }

	}
	
	public List<Hotel> getHotelsByLocationAndRating(String location, int rating) {
        return hotelRep.findByLocationAndRating(location, rating);
    }
	
	public void deleteHotel(int id) throws HotelNotFoundException {
		Optional<Hotel> hotelser = hotelRep.findById(id);
		if(hotelser.isEmpty()) {
			throw new HotelNotFoundException("Id not found");
		}
		hotelRep.deleteById(id);
		
	}

}
