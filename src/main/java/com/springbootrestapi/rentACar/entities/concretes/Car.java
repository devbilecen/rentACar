package com.springbootrestapi.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column (name="plate", unique = true)
    private String plate;

    @Column (name="state")
    private int state;

    @Column (name="dailyPrice")
    private Double dailyPrice;

    @Column (name="modelYear")
    private int modelYear;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

}
