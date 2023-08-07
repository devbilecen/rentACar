package com.springbootrestapi.rentACar.business.concretes;

import com.springbootrestapi.rentACar.business.abstracts.ModelService;
import com.springbootrestapi.rentACar.business.requests.CreateModelRequest;
import com.springbootrestapi.rentACar.business.responses.GetAllModelsResponse;
import com.springbootrestapi.rentACar.core.utilities.mappers.ModelMapperService;
import com.springbootrestapi.rentACar.dataAccess.abstracts.ModelRepository;
import com.springbootrestapi.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    public List<GetAllModelsResponse> getAll(){
        List<Model> models=modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponses =models.stream()
                .map(model->this.modelMapperService.forResponse()
                        .map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
        return  modelsResponses;    }



    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model );
    }
}

