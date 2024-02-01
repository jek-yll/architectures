package com.example.tp_hopital.controller;

import com.example.tp_hopital.repository.PrescriptionRepository;
import com.example.tp_hopital.service.PrescriptionService;
import com.example.tp_hopital.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "prescription", value = "/prescription")
public class PrescriptionServlet extends HttpServlet {

    private PrescriptionService prescriptionService;

    public void init(){
        prescriptionService = new PrescriptionService(HibernateSession.getSessionFactory(), new PrescriptionRepository());
    }

}
