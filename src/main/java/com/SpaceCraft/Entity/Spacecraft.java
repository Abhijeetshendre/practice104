package com.SpaceCraft.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.SpaceCraft.Enum.Direction;

@Entity
@Table(name = "spacecraft")
public class Spacecraft {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "x_coordinate")
	private int x;

	@Column(name = "y_coordinate")
	private int y;

	@Column(name = "z_coordinate")
	private int z;

	@Enumerated(EnumType.STRING)
	@Column(name = "direction")
	private Direction direction;
	
	

	public Spacecraft() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor
	public Spacecraft(int x, int y, int z, Direction direction) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.direction = direction;
	}

	// Getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Spacecraft [id=" + id + ", x=" + x + ", y=" + y + ", z=" + z + ", direction=" + direction + "]";
	}
	
	

}
