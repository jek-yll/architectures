package com.example.tp_hopital.repository;

import com.example.tp_hopital.entity.Prescription;

import java.util.List;

public class PrescriptionRepository extends Repository<Prescription>{
    @Override
    Prescription findById(int id) {
        return session.get(Prescription.class, id);
    }

    @Override
    List<Prescription> findAll() {
        return session.createQuery("from Patient ").list();
    }
}
