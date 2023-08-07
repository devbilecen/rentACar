package com.springbootrestapi.rentACar.dataAccess.abstracts;

import com.springbootrestapi.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    boolean  existsByName(String name);

}
