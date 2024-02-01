package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.Prescription;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.SessionFactory;

public class FicheSoinService {

    Repository<Prescription> prescriptionRepository;
    SessionFactory sessionFactory;

    public FicheSoinService(SessionFactory sessionFactory, Repository<Prescription> prescriptionRepository){
        this.prescriptionRepository = prescriptionRepository;
        this.sessionFactory = sessionFactory;
    }

}
