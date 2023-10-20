package com.saundersdemeeshia.salonappointmenttracker.domain.appointments.repos;

import com.saundersdemeeshia.salonappointmenttracker.domain.appointments.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByEmail(String email);
    List<Appointment> findByDate(String date);
    Optional<Appointment> findByPhoneNumber(String phoneNumber);
    Optional<Appointment> findByStyle(String style);
    Optional<Appointment> findById(Long id);


    List<Appointment> findAll();
    void delete(Appointment appointment);
    Appointment save(Appointment appointment);

}
