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

import com.example.NewProject.Model.Room;
import com.example.NewProject.Model.RoomNotFoundException;
import com.example.NewProject.Service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	RoomService roomSer;

	@GetMapping
	public List<Room> getHotel() throws RoomNotFoundException {
		List<Room> roomCon = roomSer.getRoom();
		return roomCon;
	}

	@GetMapping("/{id}")
	public Optional<Room> getRoomById(@PathVariable int id) throws RoomNotFoundException {
		Optional<Room> roomCon = roomSer.getRoomById(id);
		return roomCon;

	}

	@PostMapping
	public ResponseEntity<Room> addRoom(@RequestBody Room room) {
		roomSer.addRoomt(room);
		return new ResponseEntity<Room>(HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public HttpStatus upDateRoom(@RequestBody Room room, @PathVariable int id) throws RoomNotFoundException {
		roomSer.upDateRoom(room, id);
		return HttpStatus.OK;

	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteRoom(@PathVariable int id) throws RoomNotFoundException {
		roomSer.deleteRoom(id);
		return HttpStatus.OK;

	}

}
