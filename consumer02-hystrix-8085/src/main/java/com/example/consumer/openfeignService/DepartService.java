package com.example.consumer.openfeignService;

import com.example.consumer.entity.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "provider-depart1", fallbackFactory =  DepartFallBackFactory.class)
@RequestMapping("/provider/depart")
public interface DepartService {
    @RequestMapping("/get/{id}")
    Depart getDepartById(@PathVariable("id") int id);

}
