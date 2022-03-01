package ru.gb.lessons10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lessons10.entity.Manufacturer;

import java.util.Optional;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findByName(String name);
}
