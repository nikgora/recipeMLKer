package com.example.recipemlker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cookingdevice")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CookingDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long id;
    @Column(name = "title")
    private String name;

    @OneToMany(mappedBy = "device")
    private List<RecipeDevice> recipeDevices;
}

