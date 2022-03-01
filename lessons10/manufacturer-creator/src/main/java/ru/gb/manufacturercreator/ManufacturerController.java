package ru.gb.manufacturercreator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.manufacturercreator.ManufacturerDto;
import org.springframework.beans.factory.BeanCreationException;
import org.hibernate.service.spi.ServiceException;
import org.hibernate.HibernateException;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @GetMapping("/create")
    public ManufacturerDto create() {
        return ManufacturerDto.builder()
                .manufacturerId(1L)
                .name("Company from another service")
                .build();
    }
}
