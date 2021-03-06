package ru.gb.lessons10.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.lessons10.dto.ManufacturerDto;

@FeignClient(url = "localhost:8734/manufacturer", value = "manufacturerGateway")
public interface ManufacturerGateway {

    @GetMapping(value = "/create", produces = "application/json;charset=UTF-8")
    ManufacturerDto create();
}
