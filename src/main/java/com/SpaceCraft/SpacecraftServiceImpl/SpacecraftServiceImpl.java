package com.SpaceCraft.SpacecraftServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpaceCraft.DaoInterface.SpaceCraftDaoInterface;
import com.SpaceCraft.Entity.Spacecraft;
import com.SpaceCraft.ServiceInterface.ServiceInterface;
import com.SpaceCraft.SpacecraftRepository.SpacecraftRepository;

@Service
public class SpacecraftServiceImpl implements ServiceInterface {

	@Autowired
	SpaceCraftDaoInterface spaceCraftDaoInterface;
	
	//constructor
	public SpacecraftServiceImpl(SpaceCraftDaoInterface spaceCraftDaoInterface2) {
		// TODO Auto-generated constructor stub
	}

	// -----------------------------------------------------------
	// getById current spacecraft Navigation
	@Override
	public Spacecraft getCurrentNavigationById(Long spacecraftId) {
		return spaceCraftDaoInterface.getCurrentNavigationById(spacecraftId);	
	}

	// ------------------------------------------------------
	// Save current spacecraft Navigation

	@Override
	public ResponseEntity<?> saveCurrentNavigation(Spacecraft spacecraft) {

		return spaceCraftDaoInterface.saveCurrentNavigation(spacecraft);
	}

	// ----------------------------------------------------------
	//moveForward
	@Override
	public ResponseEntity<?> moveForward(Long spacecraftId) {

		return spaceCraftDaoInterface.moveForward(spacecraftId);
	}

	// ----------------------------------------------------------
	//moveBackward
	@Override
	public ResponseEntity<?> moveBackward(Long spacecraftId) {
		
		return spaceCraftDaoInterface.moveBackward(spacecraftId);
	}
	

	// ----------------------------------------------------------
	//turnLeft
	@Override
	public ResponseEntity<?> turnLeft(Long spacecraftId) {
		
		return spaceCraftDaoInterface.turnLeft(spacecraftId);
	}

	// ----------------------------------------------------------
	//turnRight
	@Override
	public ResponseEntity<?> turnRight(Long spacecraftId) {
		
		return spaceCraftDaoInterface.turnRight(spacecraftId);
	}

	// ----------------------------------------------------------
	//turnUp
	@Override
	public ResponseEntity<?> turnUp(Long spacecraftId) {
		
		return spaceCraftDaoInterface.turnUp(spacecraftId);
	}

	// ----------------------------------------------------------
	//turnDown
	@Override
	public ResponseEntity<?> turnDown(Long spacecraftId) {
		
		return spaceCraftDaoInterface.turnDown(spacecraftId);
	}


	
}
