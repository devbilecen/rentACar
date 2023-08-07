package com.springbootrestapi.rentACar.business.abstracts;

import com.springbootrestapi.rentACar.entities.concretes.Color;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ColorService {
    Color createColor(Color color);
    List<Color> findAllColors();
    List<Color> findColorWithSorting(String field);
    Page<Color> findColorWithPagination(int offset, int pageSize);
   // void checkIfColorNameExists(String name);

        //Color updateColor(Color color);
   // void deleteColor(Long colorId);
}
