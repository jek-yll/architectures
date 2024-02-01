package com.example.tp_hopital.controller;

import com.example.tp_hopital.repository.PatientRepository;
import com.example.tp_hopital.service.PatientService;
import com.example.tp_hopital.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.hibernate.Session;

@WebServlet(name = "patient", value = "/patient")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    private Session session;

    public void init(){
        session = HibernateSession.getSessionFactory().openSession();
        patientService = new PatientService(new PatientRepository(session));
    }

    
}
