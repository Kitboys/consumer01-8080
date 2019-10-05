package com.example.provider018081.service;


import com.example.provider018081.entity.Depart;

import java.util.List;

public interface DepartService {
    boolean saveDepart(Depart depart);

    boolean removeDepartById(int id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listAllDeparts();
}
