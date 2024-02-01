package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.Consultation;
import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class ConsultationService {

    Repository<Consultation> consultationRepository;
    SessionFactory sessionFactory;

    public ConsultationService(SessionFactory sessionFactory, Repository<Consultation> consultationRepository) {
        this.consultationRepository = consultationRepository;
        this.sessionFactory = sessionFactory;
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
}
