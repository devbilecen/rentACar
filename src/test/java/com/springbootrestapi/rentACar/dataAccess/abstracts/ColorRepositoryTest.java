package com.springbootrestapi.rentACar.dataAccess.abstracts;

import com.springbootrestapi.rentACar.entities.concretes.Color;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@RunWith(SpringRunner.class)

class ColorRepositoryTest {
    @Autowired
    private ColorRepository underTest;
    @Test
    void nesliCheckIfColorNameExists() {
        String renk="siyah";
        Color color= new Color(5,renk);
        underTest.save(color);
       boolean exists= underTest.checkIfColorNameExists(renk);
       assertThat(exists).isTrue();
    }
}