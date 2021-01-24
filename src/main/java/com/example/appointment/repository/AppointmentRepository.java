package com.example.appointment.repository;

import java.time.LocalDate;
import com.example.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentDateBetweenAndNameOfDoctor(LocalDate startDate, LocalDate endDate, String nameOfDoctor);

}
