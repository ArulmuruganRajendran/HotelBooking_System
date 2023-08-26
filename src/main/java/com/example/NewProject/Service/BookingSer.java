package com.example.NewProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NewProject.Model.Booking;
import com.example.NewProject.Model.BookingNotFoundException;
import com.example.NewProject.Repository.BookingRepository;

@Service
	public class BookingSer {
		@Autowired
		BookingRepository bookingRep;

		public List<Booking> getBookingr() throws BookingNotFoundException  {
			List<Booking> bookingSer = bookingRep.findAll();
			if (bookingSer.isEmpty()) {
				throw new BookingNotFoundException("booking not found");
			} else {
				return bookingSer;
			}
			
		}

		public Optional<Booking> getBookingById(int id) throws BookingNotFoundException {
			Optional<Booking> bookingser = bookingRep.findById(id);
			if (bookingser.isEmpty()) {
				throw new BookingNotFoundException("booking not found in database");
			} else {
				return bookingser;
			}
		}

		public void addBooking(Booking booking) {
			bookingRep.save(booking);
		}
        public void upDateBooking(Booking booking, int id) throws BookingNotFoundException {
			Optional<Booking> bookingSer = bookingRep.findById(id);
			if (bookingSer.isEmpty()) {
				throw new BookingNotFoundException("user not found ");

			} else {
				Booking booking1 = bookingSer.get();
				booking1.setId(booking1.getId());
				booking1.setCheckInDate(booking1.getCheckInDate());
				booking1.setCheckOutDate(booking1.getCheckOutDate());
				booking1.setTotalPrice(booking1.getTotalPrice());
				booking1.setStatus(booking1.getStatus());
				bookingRep.save(booking1);

			}

		}

		public void deleteBooking(int id) throws BookingNotFoundException {
			Optional<Booking> bookingSer = bookingRep.findById(id);
			if (bookingSer.isEmpty()) {
				throw new BookingNotFoundException("invalid id ");
			} else {
				bookingRep.deleteById(id);
			}

		}

	}

