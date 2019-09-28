package com.example.provider018081.controller;


import com.example.provider018081.entity.Depart;
import com.example.provider018081.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        depart.setDbase("test");
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean modifyHandle(@RequestBody Depart depart) {
        depart.setDbase("test");
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getDepartHandle(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listAllDepartHandle() {
        return departService.listAllDeparts();
    }
}
