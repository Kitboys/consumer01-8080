package com.example.consumer.controller;

import com.example.consumer.entity.Depart;
import com.example.consumer.openfeignService.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer/depart")
public class DepartController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String SERVICDE_PROVIDER = "http://localhost:8081/provider/depart";

    @Autowired
    private DepartService departService;

    public boolean saveHandle(Depart depart) {
        String url = SERVICDE_PROVIDER + "save";
        return restTemplate.postForObject(url, depart, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Depart getDepartHandle(@PathVariable("id") int id) {
//        String url = SERVICDE_PROVIDER + "/get/" + id;
//        return restTemplate.getForObject(url, Depart.class);
        return departService.getDepartById(id);
    }
}
