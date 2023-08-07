package com.springbootrestapi.rentACar.webApi.controllers;

import com.springbootrestapi.rentACar.business.abstracts.BrandService;
import com.springbootrestapi.rentACar.business.abstracts.ModelService;
import com.springbootrestapi.rentACar.business.requests.CreateBrandsRequest;
import com.springbootrestapi.rentACar.business.requests.CreateModelRequest;
import com.springbootrestapi.rentACar.business.responses.GetAllBrandsResponse;
import com.springbootrestapi.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
