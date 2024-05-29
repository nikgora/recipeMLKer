package com.example.recipemlker.repository;

import com.example.recipemlker.model.CookingDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<CookingDevice, Long> {
    @Query("select dev from CookingDevice dev")
    List<CookingDevice> findAll();

    CookingDevice getFirstByName(String deviceName);

    boolean existsByName(String name);
}
