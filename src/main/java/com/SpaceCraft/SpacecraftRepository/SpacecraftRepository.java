package com.SpaceCraft.SpacecraftRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpaceCraft.Entity.Spacecraft;

public interface SpacecraftRepository extends 
JpaRepository<Spacecraft, Long> {

}
