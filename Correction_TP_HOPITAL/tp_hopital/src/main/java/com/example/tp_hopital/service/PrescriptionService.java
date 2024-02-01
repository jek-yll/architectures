package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.entity.Prescription;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.SessionFactory;

public class PrescriptionService {

    Repository<Prescription> prescriptionRepository;

    SessionFactory sessionFactory;

    public PrescriptionService(SessionFactory sessionFactory, Repository<Prescription> prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.sessionFactory = sessionFactory;
    }

}
