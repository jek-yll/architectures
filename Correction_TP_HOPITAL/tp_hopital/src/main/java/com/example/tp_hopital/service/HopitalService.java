package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.*;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class HopitalService {

    SessionFactory sessionFactory;
    Repository<Patient> patientRepository;
    Repository<Consultation> consultationRepository;
    Repository<FicheSoin> ficheSoinRepository;
    Repository<Prescription> prescriptionRepository;

    public HopitalService(SessionFactory sessionFactory,
                          Repository<Patient> patientRepository,
                          Repository<Consultation> consultationRepository,
                          Repository<FicheSoin> ficheSoinRepository,
                          Repository<Prescription> prescriptionRepository
    ){
        this.sessionFactory = sessionFactory;
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.ficheSoinRepository = ficheSoinRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public boolean createPatient(String name, String phone) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        Patient patient = Patient.builder()
                .name(name)
                .phone(phone)
                .build();
        session.beginTransaction();
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
            result = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }

        return result;
    }

    public boolean createConsultation(LocalDate date, String doctor, Patient patient) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        consultationRepository.setSession(session);
        Consultation consultation = Consultation.builder()
                .date(date)
                .doctor(doctor)
                .patient(patient)
                .build();
        session.beginTransaction();
        try {
            consultationRepository.create(consultation);
            session.getTransaction().commit();
            result = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }

        return result;
    }

    public boolean createFicheSoin(Consultation consultation) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        ficheSoinRepository.setSession(session);
        FicheSoin ficheSoin = FicheSoin.builder()
                .consultation(consultation)
                .build();
        session.beginTransaction();
        try {
            ficheSoinRepository.create(ficheSoin);
            session.getTransaction().commit();
            result = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        return result;
    }

    public boolean createPrescription(String medic, FicheSoin ficheSoin) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        prescriptionRepository.setSession(session);
        Prescription prescription = Prescription.builder()
                .medic(medic)
                .ficheSoin(ficheSoin)
                .build();
        session.beginTransaction();
        try {
            prescriptionRepository.create(prescription);
            session.getTransaction().commit();
            result = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        return result;
    }

}
