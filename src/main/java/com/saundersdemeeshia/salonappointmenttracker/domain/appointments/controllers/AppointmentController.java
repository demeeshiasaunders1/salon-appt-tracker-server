package com.saundersdemeeshia.salonappointmenttracker.domain.appointments.controllers;

import com.saundersdemeeshia.salonappointmenttracker.domain.appointments.models.Appointment;
import com.saundersdemeeshia.salonappointmenttracker.domain.appointments.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@CrossOrigin("*")
public class AppointmentController {
    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        List<Appointment> appointments = appointmentService.getAll();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
        appointment = appointmentService.create(appointment);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Appointment> getById(@PathVariable("id") Long id) {
        Appointment appointment = appointmentService.getById(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Appointment> getByEmail(@RequestParam String email) {
        Appointment appointment = appointmentService.getByEmail(email);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping("lookup2")
    public ResponseEntity<List<Appointment>> getByDate(@RequestParam String date) {
        List<Appointment> appointment = appointmentService.getByDate(date);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping("lookup3")
    public ResponseEntity<Appointment> getByPhoneNumber(@RequestParam String phoneNumber) {
        Appointment appointment = appointmentService.getByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping("lookup4")
    public ResponseEntity<Appointment> getByStyle(@RequestParam String style) {
        Appointment appointment = appointmentService.getByStyle(style);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
    @PutMapping("{id}")
   public ResponseEntity<Appointment> update(@PathVariable("id") Long id, @RequestBody Appointment appointmentDetail){
       appointmentDetail = appointmentService.update(id, appointmentDetail);
       return new ResponseEntity<>(appointmentDetail, HttpStatus.ACCEPTED);
   }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        appointmentService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}