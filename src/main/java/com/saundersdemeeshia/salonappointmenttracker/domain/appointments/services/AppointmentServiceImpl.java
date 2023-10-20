package com.saundersdemeeshia.salonappointmenttracker.domain.appointments.services;

import com.saundersdemeeshia.salonappointmenttracker.domain.appointments.models.Appointment;
import com.saundersdemeeshia.salonappointmenttracker.domain.appointments.repos.AppointmentRepository;
import com.saundersdemeeshia.salonappointmenttracker.domain.core.exceptions.ResourceCreationException;
import com.saundersdemeeshia.salonappointmenttracker.domain.core.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) throws ResourceCreationException {
        Optional<Appointment> optional = appointmentRepository.findByEmail(appointment.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Booked appointment exist with email: " + appointment.getEmail());
        appointment = appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public Appointment getById(Long id) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No booked appointment with id: " + id));
        return appointment;
    }

    @Override
    public Appointment getByEmail(String email) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository.findByEmail(email).
            orElseThrow(()-> new ResourceNotFoundException("No booked appointment with email: " + email));
        return appointment;
    }

    @Override
    public List<Appointment> getByDate(String date) {
        List<Appointment> appointments = appointmentRepository.findByDate(date);
        return appointments;
    }

    @Override
    public Appointment getByPhoneNumber(String phoneNumber) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository.findByPhoneNumber(phoneNumber).
                orElseThrow(()-> new ResourceNotFoundException("No booked appointment with phoneNumber: " + phoneNumber));
        return appointment;
    }

    @Override
    public  Appointment getByStyle(String style) throws ResourceNotFoundException{
        Appointment appointment = appointmentRepository.findByStyle(style).
                orElseThrow(()-> new ResourceNotFoundException("No appointment found with the style: " + style));
        return appointment;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment update(Long id, Appointment appointmentDetail) {
        Appointment appointment = getById(id);
        appointment.setFirstName(appointmentDetail.getFirstName());
        appointment.setLastName(appointmentDetail.getLastName());
        appointment.setEmail(appointmentDetail.getEmail());
        appointment.setPhoneNumber(appointmentDetail.getPhoneNumber());
        appointment.setStyle(appointmentDetail.getStyle());
        appointment.setDate(appointmentDetail.getDate());
        appointment = appointmentRepository.save(appointment);
        return appointment;

    }

    @Override
    public void delete(Long id) {
        Appointment appointment = getById(id);
        appointmentRepository.delete(appointment);
    }
}
