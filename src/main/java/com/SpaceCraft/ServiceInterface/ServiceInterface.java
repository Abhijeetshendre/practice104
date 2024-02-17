package com.SpaceCraft.ServiceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.SpaceCraft.Entity.Spacecraft;

public interface ServiceInterface {
	
	Spacecraft getCurrentNavigationById(Long spacecraftId);
	ResponseEntity<?> saveCurrentNavigation(Spacecraft spacecraft);
	ResponseEntity<?> moveForward(Long spacecraftId);
	ResponseEntity<?> moveBackward(Long spacecraftId);
	ResponseEntity<?> turnLeft(Long spacecraftId);
    ResponseEntity<?> turnRight(Long spacecraftId);
    ResponseEntity<?> turnUp(Long spacecraftId);
    ResponseEntity<?> turnDown(Long spacecraftId);
	
}
