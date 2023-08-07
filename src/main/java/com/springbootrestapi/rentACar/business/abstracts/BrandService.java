package com.springbootrestapi.rentACar.business.abstracts;


import com.springbootrestapi.rentACar.business.requests.CreateBrandsRequest;
import com.springbootrestapi.rentACar.business.requests.UpdateBrandRequest;
import com.springbootrestapi.rentACar.business.responses.*;
import com.springbootrestapi.rentACar.entities.concretes.Brand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {
    public List<GetAllBrandsResponse> getAll();
    public GetSortAllBrandsResponse <List<Brand> >findBrandsWithSorting(String field);
    public GetPaginationAllBrandsResponse<Page<Brand>> findBrandsWithPagination(int offset, int pageSize);
    public GetPaginationAndSortAllBrandsResponse<Page<Brand>> findBrandsWithPaginationAndSorting(int offset, int pageSize, String field);



    void add(CreateBrandsRequest createBrandsRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    GetByIdBrandResponse getById(int id);

    // public Page<Brand> findBrandsWithPagination(int offset, int pageSize);

    }
