package com.springbootrestapi.rentACar.webApi.controllers;

import com.springbootrestapi.rentACar.business.abstracts.BrandService;
import com.springbootrestapi.rentACar.business.requests.CreateBrandsRequest;
import com.springbootrestapi.rentACar.business.requests.UpdateBrandRequest;
import com.springbootrestapi.rentACar.business.responses.*;
import com.springbootrestapi.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @GetMapping
    public List<GetAllBrandsResponse> getAll(){
        return this.brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandsRequest createBrandsRequest){
         this.brandService.add(createBrandsRequest);
    }

    @PutMapping
    public void update (@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable int id){
        this.brandService.delete(id);
    }

    @GetMapping("/sort/{field}")
    public GetSortAllBrandsResponse<List<Brand>> findAllBrandsWithSorting(@PathVariable("field") String field){
        return brandService.findBrandsWithSorting(field);
    }

    @GetMapping("/page/{offset}/{pageSize}")
    public GetPaginationAllBrandsResponse<Page<Brand>> findAllBrandsWithPaging(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize){
        return  brandService.findBrandsWithPagination(offset, pageSize);
    }


    @GetMapping("/page/{offset}/{pageSize}/sort/{field}")
    public GetPaginationAndSortAllBrandsResponse <Page<Brand>> findAllBrandsWithPagingAndSorting(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize,@PathVariable("field") String field){
        return  brandService.findBrandsWithPaginationAndSorting(offset, pageSize,field);
    }
}
