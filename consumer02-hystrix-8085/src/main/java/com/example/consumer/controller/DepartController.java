package com.example.consumer.controller;

import com.example.consumer.entity.Depart;
import com.example.consumer.openfeignService.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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


    //服务降级，若当前处理器发生异常，则执行fallbackMethod属性指定的方法
    @HystrixCommand(fallbackMethod = "getHystruxHandle")
    @GetMapping("/get/{id}")
    public Depart getDepartHandle(@PathVariable("id") int id) {
        String url = SERVICDE_PROVIDER + "/get/" + id;
//        Depart de = restTemplate.getForObject(url, Depart.class);
//        if (de == null) {
//            throw  new RuntimeException("no this depart : " + id);
//        }
//        return de;
        Depart departById = departService.getDepartById(id);
        System.out.println(departById);
        return departById;
    }

    public Depart getHystruxHandle(@PathVariable("id") int id) {
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart ");
        depart.setDbase("no this db");
        return depart;
    }
    @RequestMapping("test")
    public String test(){
        return "test String";
    }
}
