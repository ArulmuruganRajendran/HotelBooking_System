package com.example.NewProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NewProject.Model.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
