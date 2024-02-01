package com.example.tp_hopital.repository;

import com.example.tp_hopital.entity.FicheSoin;

import java.util.List;

public class FicheSoinRepository extends Repository<FicheSoin>{

    @Override
    FicheSoin findById(int id) {
        return session.get(FicheSoin.class, id);
    }

    @Override
    List<FicheSoin> findAll() {
        return session.createQuery("from FicheSoin ").list();
    }
}
