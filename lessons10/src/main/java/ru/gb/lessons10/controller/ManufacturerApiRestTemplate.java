package ru.gb.lessons10.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.gb.lessons10.dto.ManufacturerDto;
import ru.gb.lessons10.controller.ManufacturerApiRestTemplate;

import java.net.URI;

@Slf4j
@Component
@Primary
public class ManufacturerApiRestTemplate implements ManufacturerApi {

    private static final String URL = "http://localhost:8734/manufacturer/create";

    private final RestTemplate restTemplate;

    @Autowired
    public ManufacturerApiRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ManufacturerDto create() {
       /// log.error("through RestTemplate");
        return restTemplate.getForObject(URI.create(URL), ManufacturerDto.class);
    }
}
