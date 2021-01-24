package com.example.appointment.repository;

import com.example.appointment.model.Appointment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.time.LocalDate;

@Configuration
@Slf4j
public class LoadDataRepository {

    static final private Logger logger = LoggerFactory.getLogger(LoadDataRepository.class);

    @Bean
    CommandLineRunner initDatabase(AppointmentRepository appointmentRepository) {
        return args -> {
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2021, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Linus Torvalds", "Janusz Kowalski", 1111, 2356)));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2021, 3, 3), Time.valueOf("13:00:00"),  Time.valueOf("13:00:00"),"Linus Torvalds", "Roman Nowak", 1112, 4555)));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2021, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Bill Gates", "Roman Nowak", 1112, 4555)));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2021, 1, 10), Time.valueOf("08:00:00"),  Time.valueOf("09:00:00"),"Elon Musk", "Ryszard Padlo", 1113, 3232)));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2021, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"James Gosling", "Nikodem Szczepanaiak", 1114, 4343)));
        };
    }
}
