package com.saundersdemeeshia.salonappointmenttracker.domain.appointments.services;

import com.saundersdemeeshia.salonappointmenttracker.domain.appointments.models.Appointment;
import com.saundersdemeeshia.salonappointmenttracker.domain.core.exceptions.ResourceCreationException;
import com.saundersdemeeshia.salonappointmenttracker.domain.core.exceptions.ResourceNotFoundException;

import java.util.List;

public interface AppointmentService {
    Appointment create(Appointment appointment) throws ResourceCreationException;
    Appointment getById(Long id) throws ResourceNotFoundException;
    Appointment getByEmail(String email) throws ResourceNotFoundException;
    List<Appointment> getByDate(String date) throws ResourceNotFoundException;
    Appointment getByPhoneNumber(String phoneNumber) throws  ResourceNotFoundException;
    Appointment getByStyle(String style) throws  ResourceNotFoundException;
    List<Appointment> getAll();
    Appointment update(Long id, Appointment appointmentDetail) throws ResourceNotFoundException;

    void delete(Long id);

}
