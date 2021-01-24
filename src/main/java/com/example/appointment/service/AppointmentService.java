package com.example.appointment.service;

import com.example.appointment.model.Appointment;


import java.util.List;
import java.time.LocalDate;


public interface AppointmentService {

    List<Appointment> findAll();

    Appointment create(Appointment appointment);

    Appointment updateStatus(Long appointmentId, Appointment appointment);

    List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate, String nameOfDoctor);

}
