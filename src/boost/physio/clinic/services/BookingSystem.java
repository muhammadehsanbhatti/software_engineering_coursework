/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boost.physio.clinic.services;

import boost.physio.clinic.pojos.Appointment;
import boost.physio.clinic.pojos.Patient;
import boost.physio.clinic.pojos.Physiotherapist;
import boost.physio.clinic.pojos.Treatment;

/**
 *
 * @author ehsan
 */
public class BookingSystem {
    private Clinic clinic;

    public BookingSystem(Clinic clinic) {
        this.clinic = clinic;
    }

    public Appointment bookAppointment(Patient patient, Physiotherapist physiotherapist, Treatment treatment, String timeSlot) {
        Appointment appointment = new Appointment(patient, physiotherapist, treatment, timeSlot);
        patient.addAppointment(appointment);
        System.out.println("Appointment booked: " + appointment.getDetails());
        return appointment;
    }

    public void cancelAppointment(Appointment appointment) {
        appointment.cancel();
        System.out.println("Appointment cancelled: " + appointment.getDetails());
    }
}
