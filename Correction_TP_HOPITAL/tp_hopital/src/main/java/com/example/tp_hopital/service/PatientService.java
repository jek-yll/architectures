package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.Session;

public class PatientService {
    Repository<Patient> patientRepository;
    Session session;
    public PatientService(Repository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
        this.session = patientRepository.getSession();
    }
}
