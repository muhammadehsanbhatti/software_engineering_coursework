/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boost.physio.clinic;

import boost.physio.clinic.pojos.Appointment;
import boost.physio.clinic.pojos.Patient;
import boost.physio.clinic.pojos.Physiotherapist;
import boost.physio.clinic.pojos.Treatment;
import boost.physio.clinic.services.BookingSystem;
import boost.physio.clinic.services.Clinic;
import boost.physio.clinic.services.ReportGenerator;
import java.util.List;

/**
 *
 * @author ehsan
 */
public class BoostPhysioClinic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        BookingSystem bookingSystem = new BookingSystem(clinic);

        // Adding Physiotherapists
        Physiotherapist physio1 = new Physiotherapist(1, "Dr. Smith", "123456789", "Massage", List.of(new Treatment("Massage", null, "10:00 AM")));
        Physiotherapist physio2 = new Physiotherapist(2, "Dr. Brown", "987654321", "Rehabilitation", List.of(new Treatment("Rehabilitation", null, "2:00 PM")));
        clinic.addPhysiotherapist(physio1);
        clinic.addPhysiotherapist(physio2);

        // Adding Patients
        Patient patient1 = new Patient(1, "John Doe", "New York", "111222333");
        clinic.addPatient(patient1);

        // Booking Appointments
        Appointment appointment = bookingSystem.bookAppointment(patient1, physio1, physio1.getTreatments().get(0), "10:00 AM");

        // Generating Reports
        ReportGenerator.generateAppointmentsReport(List.of(patient1));
    }
    
}
