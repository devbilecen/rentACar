package com.springbootrestapi.rentACar.dataAccess.abstracts;

import com.springbootrestapi.rentACar.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer>{

	//Color findById(int id);
	Color findByName(String name);
	boolean checkIfColorNameExists(String name);

	}
