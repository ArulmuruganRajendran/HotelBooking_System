package com.example.NewProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NewProject.Model.Room;
import com.example.NewProject.Model.RoomNotFoundException;
import com.example.NewProject.Repository.RoomRepository;
@Service
public class RoomService {
	@Autowired
	RoomRepository roomRep;

	public List<Room> getRoom() throws RoomNotFoundException {
		List<Room> roomSer = roomRep.findAll();
		if (roomSer.isEmpty()) {
			throw new RoomNotFoundException("room not Found");
		} else {
			return roomSer;
		}
	}

	public Optional<Room> getRoomById(int id) throws RoomNotFoundException {
		Optional<Room> roomSer = roomRep.findById(id);
		if (roomSer.isEmpty()) {
			throw new RoomNotFoundException("Id is not found ");
		} else {
			return roomSer;
		}
	}

	public void addRoomt(Room room) {
		roomRep.save(room);
	}

	public void upDateRoom(Room room, int id) throws RoomNotFoundException {
		Optional<Room> roomSer = roomRep.findById(id);
		if (roomSer.isEmpty()) {
			throw new RoomNotFoundException("Id not Found ");
		} else {
			Room roomm = roomSer.get();
			roomm.setId(roomm.getId());
			roomm.setRoomNumber(roomm.getRoomNumber());
			roomm.setType(roomm.getType());
			roomm.setPrice(roomm.getPrice());
			roomm.setDescription(room.getDescription());
			roomRep.save(roomm);
		}

	}

	public void deleteRoom(int id) throws RoomNotFoundException {
		Optional<Room> roomSer = roomRep.findById(id);
		if (roomSer.isEmpty()) {
			throw new RoomNotFoundException("Id not found");
		}
		roomRep.deleteById(id);

	}

}



