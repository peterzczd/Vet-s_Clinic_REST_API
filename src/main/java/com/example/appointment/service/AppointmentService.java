package com.example.appointment.service;

import com.example.appointment.model.Appointment;


import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> findAll();

    List<Appointment> findBynameOfDoctor(String nameOfDoctor);

    Appointment create(Appointment appointment);

    Appointment updateStatus(Long appointmentId, Appointment appointment);

}
