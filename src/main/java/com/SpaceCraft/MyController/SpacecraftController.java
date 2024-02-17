package com.SpaceCraft.MyController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpaceCraft.Entity.Spacecraft;
import com.SpaceCraft.ServiceInterface.ServiceInterface;

@RestController
@RequestMapping("/spacecraft")
public class SpacecraftController {
	@Autowired
	private ServiceInterface spacecraftService;
	// --------------------------------------------------------

	// getById current spacecraft Navigation
	@GetMapping("/getCurrentNavigationById/{id}")
	public ResponseEntity<?> getCurrentNavigationById(@PathVariable Long id) {
		Spacecraft currentDirectionById = spacecraftService.getCurrentNavigationById(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currunt Navigation -"+"\n"+currentDirectionById);
		

	}

	// ------------------------------------------------------
    // Save current spacecraft Navigation
	@PostMapping("/saveCurrentNavigation")
	public ResponseEntity<?> saveCurrentNavigation(@RequestBody Spacecraft spacecraft) {
		return spacecraftService.saveCurrentNavigation(spacecraft);

	}

	// ------------------------------------------------------
	// moveForward

	@PutMapping("/moveForward/{id}")
	public ResponseEntity<?> moveForward(@PathVariable Long id) {
		return spacecraftService.moveForward(id);

	}

	//---------------------------------------------------
	// moveBackward
	
	@PutMapping("/moveBackward/{id}")
	public ResponseEntity<?> moveBackward(@PathVariable Long id) {
		return spacecraftService.moveBackward(id);
		
	}
	//---------------------------------------------------
	// turnLeft
	@PutMapping("/turnLeft/{id}")
	public ResponseEntity<?> turnLeft(@PathVariable Long id) {
		return spacecraftService.turnLeft(id);
	}
	
	// ----------------------------------------------------------
	// turnRight

	@PutMapping("/turnRight/{id}")
	public ResponseEntity<?> turnRight(@PathVariable Long id) {
		return spacecraftService.turnRight(id);
	}
	
	// ----------------------------------------------------------
	// turnUp

	@PutMapping("/turnUp/{id}")
	public ResponseEntity<?> turnUp(@PathVariable Long id) {
		return spacecraftService.turnUp(id);
	}

	// ----------------------------------------------------------
	// turnDown
	
	@PutMapping("/turnDown/{id}")
	public ResponseEntity<?> turnDown(@PathVariable Long id) {
		return spacecraftService.turnDown(id);
	}

}
