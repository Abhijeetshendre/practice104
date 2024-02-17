package com.SpaceCraft.DaoInterface;

import org.springframework.http.ResponseEntity;

import com.SpaceCraft.Entity.Spacecraft;

public interface SpaceCraftDaoInterface {
	
	Spacecraft getCurrentNavigationById(Long spacecraftId);
	ResponseEntity<?> saveCurrentNavigation(Spacecraft spacecraft);
	ResponseEntity<?> moveForward(Long spacecraftId);
	ResponseEntity<?> moveBackward(Long spacecraftId);
	ResponseEntity<?> turnLeft(Long spacecraftId);
    ResponseEntity<?> turnRight(Long spacecraftId);
	ResponseEntity<?> turnUp(Long spacecraftId);
    ResponseEntity<?> turnDown(Long spacecraftId);

}
