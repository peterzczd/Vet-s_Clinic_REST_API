package com.example.appointment.controller;

import com.example.appointment.model.Appointment;
import com.example.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentRestController {

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentRestController() {
    }

    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    /** GET request to return all appointments based on a date range and ordered by price **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Appointment> findByDateRangeSortedByPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate, @RequestParam("nameOfDoctor") String nameOfDoctor) {
        return appointmentService.findByDateRangeSortedByPrice(startDate, endDate, nameOfDoctor);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    /** GET request to return all appointments based on a doctor's name **/
    /*@RequestMapping(method = RequestMethod.GET)
    public List<Appointment> findBynameOfDoctor(@RequestParam("nameOfDoctor") String nameOfDoctor) {
        return appointmentService.findBynameOfDoctor(nameOfDoctor);
    }*/

    /** POST request to add new appointments **/
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

    /** PATCH request to update status of an appointment  - to cancel appointment**/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PATCH, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment updateStatus(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.updateStatus(appointmentId, appointment);
    }
}
