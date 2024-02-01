package com.example.tp_hopital.controller;

import com.example.tp_hopital.repository.ConsultationRepository;
import com.example.tp_hopital.service.ConsultationService;
import com.example.tp_hopital.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "consultation", value = "/consultation")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;

    public void init(){
        consultationService = new ConsultationService(HibernateSession.getSessionFactory(), new ConsultationRepository());
    }
}
