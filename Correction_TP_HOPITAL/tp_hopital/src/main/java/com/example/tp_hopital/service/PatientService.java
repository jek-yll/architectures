package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.Session;

public class PatientService {
    Repository<Patient> patientRepository;
    Session session;
    public PatientService(Repository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
        this.session = patientRepository.getSession();
    }

    public boolean createPatient(String name, String phone) throws RepositoryException {
        boolean result = false;
        Patient patient = Patient.builder()
                .name(name)
                .phone(phone)
                .build();
        session.beginTransaction();
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e){
            session.getTransaction().rollback();
            throw new RepositoryException();
        } finally {
            session.close();
        }
        return result;
    }


}
