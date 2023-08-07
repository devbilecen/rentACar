package com.springbootrestapi.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaginationAllBrandsResponse<T> {
    private int id;
    T response;
}
