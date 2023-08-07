package com.springbootrestapi.rentACar.business.rules;

import com.springbootrestapi.rentACar.core.utilities.exceptions.BusinessException;
import com.springbootrestapi.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists");
        }

    }
}
