package com.springbootrestapi.rentACar.business.concretes;

import com.springbootrestapi.rentACar.business.abstracts.ColorService;
import com.springbootrestapi.rentACar.core.utilities.exceptions.BusinessException;
import com.springbootrestapi.rentACar.dataAccess.abstracts.ColorRepository;
import com.springbootrestapi.rentACar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    @Autowired
    private ColorRepository colorRepository;


    public void checkIfColorNameExists(String name) {
        Color currentColor = this.colorRepository.findByName(name);
        if(currentColor != null) {
            throw new BusinessException("COLOR.NAME.EXISTS");
        }
    }
    @Override
    public Color createColor(Color color) {
        return colorRepository.save(color);
    }
    @Override
    public List<Color> findAllColors() {
        return colorRepository.findAll();
    }
    public List<Color> findColorWithSorting(String field) {
        return colorRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    public Page<Color> findColorWithPagination(int offset, int pageSize) {
        System.out.println("findPersonelWithPagination");
        Page<Color> color= colorRepository.findAll(PageRequest.of(offset,pageSize));
        return color;
    }


   /* @Override
    public void deleteColor(Long personelId) {
        colorRepository.deleteById(ColorId.intValue());
    }*/
}
