package com.springbootrestapi.rentACar.business.concretes;

import com.springbootrestapi.rentACar.business.abstracts.BrandService;
import com.springbootrestapi.rentACar.business.requests.CreateBrandsRequest;
import com.springbootrestapi.rentACar.business.requests.UpdateBrandRequest;
import com.springbootrestapi.rentACar.business.responses.*;
import com.springbootrestapi.rentACar.business.rules.BrandBusinessRules;
import com.springbootrestapi.rentACar.core.utilities.mappers.ModelMapperService;
import com.springbootrestapi.rentACar.dataAccess.abstracts.BrandRepository;
import com.springbootrestapi.rentACar.entities.concretes.Brand;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandsRequest createBrandsRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandsRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandsRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        System.out.println(id + " " + "GetByIdBrandResponse");
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response =
                this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    public GetSortAllBrandsResponse<List<Brand>> findBrandsWithSorting(String field) {
        List<Brand> brandList = brandRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        return new GetSortAllBrandsResponse<>(brandList.size(), brandList);
    }

    @Override
    public GetPaginationAllBrandsResponse<Page<Brand>> findBrandsWithPagination(int offset, int pageSize) {
        System.out.println("findBrandsWithPagination");
        Page<Brand> brandsPage= brandRepository.findAll(PageRequest.of(offset,pageSize));
        return new GetPaginationAllBrandsResponse<>(brandsPage.getSize(),brandsPage) ;
    }

    @Override
    public GetPaginationAndSortAllBrandsResponse<Page<Brand>>findBrandsWithPaginationAndSorting(int offset, int pageSize, String field) {
        System.out.println("findBrandsWithPagination");
        Page<Brand> brandsPage= brandRepository.findAll(PageRequest.of(offset,pageSize,Sort.by(Sort.Direction.ASC,field)));
        return new GetPaginationAndSortAllBrandsResponse<>(brandsPage.getSize(),brandsPage);
    }
}

