package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component("appointmentService")
public class AppointmentServiceImplementation implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImplementation() {
    }

    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /*public List<Appointment> findBynameOfDoctor(String nameOfDoctor) {
        return appointmentRepository.findBynameOfDoctor(nameOfDoctor);
    }
*/
    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateStatus(Long appointmentId, Appointment appointment) {

        Optional<Appointment> appointmentList = appointmentRepository.findById(appointmentId);

        if(appointmentList.isPresent()){
            if(appointment.getStatus() != null){
                appointmentList.get().setStatus(appointment.getStatus());
            }
            return appointmentRepository.save(appointmentList.get());
        }
        return null;
    }
    @Override
    public List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate, String nameOfDoctor) {
        return appointmentRepository.findAllByAppointmentDateBetweenAndNameOfDoctor(startDate, endDate,nameOfDoctor);
    }
}
