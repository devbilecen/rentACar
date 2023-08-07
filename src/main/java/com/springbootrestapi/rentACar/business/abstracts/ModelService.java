package com.springbootrestapi.rentACar.business.abstracts;

import com.springbootrestapi.rentACar.business.requests.CreateBrandsRequest;
import com.springbootrestapi.rentACar.business.requests.CreateModelRequest;
import com.springbootrestapi.rentACar.business.responses.GetAllModelsResponse;
import com.springbootrestapi.rentACar.dataAccess.abstracts.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);

}
