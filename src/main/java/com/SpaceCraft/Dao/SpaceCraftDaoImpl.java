package com.SpaceCraft.Dao;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.SpaceCraft.Confige.SpacecraftConstants;
import com.SpaceCraft.DaoInterface.SpaceCraftDaoInterface;
import com.SpaceCraft.Entity.Spacecraft;
import com.SpaceCraft.SpacecraftRepository.SpacecraftRepository;
import com.SpaceCraft.Enum.*;

@Repository
public class SpaceCraftDaoImpl implements SpaceCraftDaoInterface {

	@Autowired
	SpacecraftRepository spacecraftRepository;

	// -----------------------------------------------------------
	// getById current spacecraft Navigation
	@Override
	public Spacecraft getCurrentNavigationById(Long spacecraftId) {
		Spacecraft spacecraftById = spacecraftRepository.findById(spacecraftId)
				.orElseThrow(() -> new EntityNotFoundException("Spacecraft not found with id: " + spacecraftId));
		return spacecraftById;
	}

	// ------------------------------------------------------
	// Save current spacecraft Navigation
	@Override
	public ResponseEntity<?> saveCurrentNavigation(Spacecraft spacecraft) {
		try {
			spacecraftRepository.save(spacecraft);
			return ResponseEntity.status(HttpStatus.CREATED).body( spacecraft);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("bad req not save" + "\n" + spacecraft);
		}

	}

	// ----------------------------------------------------------
	// moveForward
	@Override
	public ResponseEntity<?> moveForward(Long spacecraftId) {

		// Get current Navigation By Id
		Spacecraft spacecraftById = getCurrentNavigationById(spacecraftId);

		// Get the current direction of the spacecraft
		com.SpaceCraft.Enum.Direction currentDirectionBuId = spacecraftById.getDirection();

		// Update the spacecraft's coordinates based on its current direction
		switch (currentDirectionBuId) {
		case NORTH:
			if (spacecraftById.getY() < SpacecraftConstants.MAX_Y_COORDINATE) {
				spacecraftById.setY(spacecraftById.getY() + 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached maximum y-coordinate boundary");
			}
			break;
		case SOUTH:
			if (spacecraftById.getY() > SpacecraftConstants.MIN_Y_COORDINATE) {
				spacecraftById.setY(spacecraftById.getY() - 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached minimum y-coordinate boundary");
			}
			break;
		case EAST:
			if (spacecraftById.getX() < SpacecraftConstants.MAX_X_COORDINATE) {
				spacecraftById.setX(spacecraftById.getX() + 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached maximum x-coordinate boundary");
			}
			break;
		case WEST:
			if (spacecraftById.getX() > SpacecraftConstants.MIN_X_COORDINATE) {
				spacecraftById.setX(spacecraftById.getX() - 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached minimum x-coordinate boundary");
			}
			break;
		case UP:
			if (spacecraftById.getZ() < SpacecraftConstants.MAX_Z_COORDINATE) {
				spacecraftById.setZ(spacecraftById.getZ() + 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached maximum z-coordinate boundary");
			}
			break;
		case DOWN:
			if (spacecraftById.getZ() > SpacecraftConstants.MIN_Z_COORDINATE) {
				spacecraftById.setZ(spacecraftById.getZ() - 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached minimum z-coordinate boundary");
			}
			break;
		}

		// Save the updated spacecraft coordinates to the database
		return saveCurrentNavigation(spacecraftById);
		
		
	}

	// ----------------------------------------------------------
	// moveBackward
	@Override
	public ResponseEntity<?> moveBackward(Long spacecraftId) {
		// Get current Navigation By Id
		Spacecraft spacecraftById = getCurrentNavigationById(spacecraftId);

		// Get the current direction of the spacecraft
		com.SpaceCraft.Enum.Direction currentDirectionBuId = spacecraftById.getDirection();

		// Update the spacecraft's coordinates based on its current direction
		switch (currentDirectionBuId) {
		case NORTH:
			if (spacecraftById.getY() < SpacecraftConstants.MAX_Y_COORDINATE) {
				spacecraftById.setY(spacecraftById.getY() - 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached maximum y-coordinate boundary");
			}
			break;
		case SOUTH:
			if (spacecraftById.getY() > SpacecraftConstants.MIN_Y_COORDINATE) {
				spacecraftById.setY(spacecraftById.getY() + 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached minimum y-coordinate boundary");
			}
			break;
		case EAST:
			if (spacecraftById.getX() < SpacecraftConstants.MAX_X_COORDINATE) {
				spacecraftById.setX(spacecraftById.getX() - 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached maximum x-coordinate boundary");
			}
			break;
		case WEST:
			if (spacecraftById.getX() > SpacecraftConstants.MIN_X_COORDINATE) {
				spacecraftById.setX(spacecraftById.getX() + 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached minimum x-coordinate boundary");
			}
			break;
		case UP:
			if (spacecraftById.getZ() < SpacecraftConstants.MAX_Z_COORDINATE) {
				spacecraftById.setZ(spacecraftById.getZ() - 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached maximum z-coordinate boundary");
			}
			break;
		case DOWN:
			if (spacecraftById.getZ() > SpacecraftConstants.MIN_Z_COORDINATE) {
				spacecraftById.setZ(spacecraftById.getZ() + 1);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot move forward, reached minimum z-coordinate boundary");
			}
			break;
		}

		// Save the updated spacecraft coordinates to the database
		return saveCurrentNavigation(spacecraftById);
	}

	// ----------------------------------------------------------
	// turnLeft

	@Override
	public ResponseEntity<?> turnLeft(Long spacecraftId) {
		// Get current Navigation By Id
		Spacecraft spacecraftById = getCurrentNavigationById(spacecraftId);

		// Get the current direction of the spacecraft
		com.SpaceCraft.Enum.Direction currentDirectionBuId = spacecraftById.getDirection();

		// Update the direction of the spacecraft by turning left
		com.SpaceCraft.Enum.Direction newDirection;
		switch (currentDirectionBuId) {
		case NORTH:
			newDirection = com.SpaceCraft.Enum.Direction.WEST;
			break;
		case SOUTH:
			newDirection = com.SpaceCraft.Enum.Direction.EAST;
			break;
		case EAST:
			newDirection = com.SpaceCraft.Enum.Direction.NORTH;
			break;
		case WEST:
			newDirection = com.SpaceCraft.Enum.Direction.SOUTH;
			break;
		case UP:
		case DOWN:
			// Since the spacecraft can only turn
			// left on the x-y plane, no change in direction for UP or DOWN
			newDirection = currentDirectionBuId;
			break;
		default:
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid direction");
		}

		// Save the updated spacecraft Dirction to the database
		spacecraftById.setDirection(newDirection);
		// Save the updated spacecraft coordinates to the database
		return saveCurrentNavigation(spacecraftById);
	}

	// ----------------------------------------------------------
	// turnRight
	@Override
	public ResponseEntity<?> turnRight(Long spacecraftId) {
		// Get current Navigation By Id
		Spacecraft spacecraftById = getCurrentNavigationById(spacecraftId);

		// Get the current direction of the spacecraft
		com.SpaceCraft.Enum.Direction currentDirectionBuId = spacecraftById.getDirection();

		// Update the direction of the spacecraft by turning left
		com.SpaceCraft.Enum.Direction newDirection;
		switch (currentDirectionBuId) {
		case NORTH:
			newDirection = com.SpaceCraft.Enum.Direction.EAST;
			break;
		case SOUTH:
			newDirection = com.SpaceCraft.Enum.Direction.WEST;
			break;
		case EAST:
			newDirection = com.SpaceCraft.Enum.Direction.SOUTH;
			break;
		case WEST:
			newDirection = com.SpaceCraft.Enum.Direction.NORTH;
			break;
		case UP:
		case DOWN:
			// Since the spacecraft can only turn
			// left on the x-y plane, no change in direction for UP or DOWN
			newDirection = currentDirectionBuId;
			break;
		default:
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid direction");
		}

		// Save the updated spacecraft Dirction to the database
		spacecraftById.setDirection(newDirection);
		// Save the updated spacecraft coordinates to the database
		return saveCurrentNavigation(spacecraftById);
	}

	// ----------------------------------------------------------
	// turnUp
	@Override
	public ResponseEntity<?> turnUp(Long spacecraftId) {
		// Get current Navigation By Id
		Spacecraft spacecraftById = getCurrentNavigationById(spacecraftId);

		// Get the current direction of the spacecraft
		com.SpaceCraft.Enum.Direction currentDirectionBuId = spacecraftById.getDirection();

		// Check if the spacecraft is currently facing in an upward direction
		if (currentDirectionBuId != com.SpaceCraft.Enum.Direction.UP) {
			// Update the direction of the spacecraft to UP
			spacecraftById.setDirection(com.SpaceCraft.Enum.Direction.UP);
			saveCurrentNavigation(spacecraftById);

			return ResponseEntity.status(HttpStatus.OK).body("Turned up successfully. New direction: UP."
					+ " Spacecraft ID: " + "X Coordinate: " + "\n" + spacecraftById);

		} else {
			// If the spacecraft is already facing UP, return a message indicating that it
			// cannot turn further up
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Spacecraft is already facing upward");
		}
	}

	// ----------------------------------------------------------
	// turnDown
	@Override
	public ResponseEntity<?> turnDown(Long spacecraftId) {
		// Get current Navigation By Id
		Spacecraft spacecraftById = getCurrentNavigationById(spacecraftId);

		// Get the current direction of the spacecraft
		com.SpaceCraft.Enum.Direction currentDirectionBuId = spacecraftById.getDirection();

		// Check if the spacecraft is currently facing in an upward direction
		if (currentDirectionBuId != com.SpaceCraft.Enum.Direction.DOWN) {
			// Update the direction of the spacecraft to UP
			spacecraftById.setDirection(com.SpaceCraft.Enum.Direction.DOWN);
			saveCurrentNavigation(spacecraftById);

			return ResponseEntity.status(HttpStatus.OK)
					.body("Turned dowm successfully. New direction: DOWN." + "\n" + spacecraftById);

		} else {
			// If the spacecraft is already facing UP, return a message indicating that it
			// cannot turn further up
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Spacecraft is already facing downward");
		}

	}

}
