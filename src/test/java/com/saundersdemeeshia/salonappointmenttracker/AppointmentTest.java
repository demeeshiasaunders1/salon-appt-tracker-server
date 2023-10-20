package com.saundersdemeeshia.salonappointmenttracker;

import com.saundersdemeeshia.salonappointmenttracker.domain.appointments.models.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    @Test
    public void constructorTest01(){
        Appointment appointment = new Appointment("Melissa","Demo", "MelissaDemo@mock.com", "281-330-8004", "blunt cut bob", "10/21/2023");
        appointment.setId(2l);

        String expected= "(2) Melissa Demo MelissaDemo@mock.com 281-330-8004 Style: blunt cut bob - 10/21/2023";
        String actual = appointment.toString();

        Assertions.assertEquals(expected, actual);
    }
}
