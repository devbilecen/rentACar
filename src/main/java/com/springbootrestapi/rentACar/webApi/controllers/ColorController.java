package com.springbootrestapi.rentACar.webApi.controllers;

import com.springbootrestapi.rentACar.business.abstracts.ColorService;
import com.springbootrestapi.rentACar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/color")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @PostMapping
    public ResponseEntity<Color> createColor(@RequestBody Color color){
        Color savedColor = colorService.createColor(color);
        return new ResponseEntity<>(savedColor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Color>> getAllPersonel(){
        List<Color> color = colorService.findAllColors();
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @GetMapping("/{field}")
    public ResponseEntity<List<Color>> getAllColorWithSort(@PathVariable String field){
        System.out.println("getAllPersonelWithSort");
        List<Color> color = colorService.findColorWithSorting(field);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity <Page<Color>> getAllPersonelWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        System.out.println("getAllPersonelWithPagination");
        Page<Color> colorWithPagination = colorService.findColorWithPagination(offset, pageSize);
        return new ResponseEntity<>(colorWithPagination, HttpStatus.OK);
    }
}
