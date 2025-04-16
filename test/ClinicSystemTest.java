/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahsan
 */
import boost.physio.clinic.pojos.Appointment;
import boost.physio.clinic.pojos.Patient;
import boost.physio.clinic.pojos.Physiotherapist;
import boost.physio.clinic.pojos.Treatment;
import boost.physio.clinic.services.BookingSystem;
import boost.physio.clinic.services.Clinic;
import boost.physio.clinic.services.ReportGenerator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ClinicSystemTest {

    private Patient patient;
    private Physiotherapist physio;
    private Treatment treatment;
    private Appointment appointment;
    private BookingSystem bookingSystem;
    private Clinic clinic;
    private ReportGenerator reportGenerator;

    @Before
    public void setUp() {
        
        physio = new Physiotherapist(1, "Dr. Smith", "123456789", "Massage", List.of(new Treatment("Massage", null, "10:00 AM")));
        treatment = physio.getTreatments().get(0);
        appointment = new Appointment(patient, physio, treatment,treatment.getTimeSlot() );
        clinic = new Clinic();
        bookingSystem = new BookingSystem(clinic);
        
        reportGenerator = new ReportGenerator();
    }

    // Test: Patient
    @Test
    public void testPatientInfo() {
        assertEquals("John Doe", patient.getName());
        assertEquals("123456789", patient.getPhone());
    }

    // Test: Physiotherapist
    @Test
    public void testPhysiotherapistInfo() {
        assertEquals("Alice Smith", physio.getName());
        assertEquals("Physio123", physio.getId());
    }

    // Test: Treatment
    @Test
    public void testTreatmentInfo() {
        assertEquals("Back Pain", treatment.getName());
        assertEquals(60, treatment.getTimeSlot());
    }

    // Test: Appointment
    @Test
    public void testAppointmentCreation() {
        assertEquals(patient, appointment.getPatient());
        assertEquals(physio, appointment.getPhysiotherapist());
        assertEquals(treatment, appointment.getTreatment());
        assertNotNull(appointment.getTimeSlot());
    }

    // Test: BookingSystem
    @Test
    public void testBookingSystemSchedule() {
        bookingSystem.bookAppointment(patient,physio ,treatment,"10:00 AM");
        List<Appointment> appointments = bookingSystem.getClinic().getPatients().get(0).getAppointments() ;
        assertTrue(appointments.contains(appointment));
    }

    // Test: Clinic
    @Test
    public void testClinicAddPatient() {
        clinic.addPatient(patient);
        assertTrue(clinic.getPatients().contains(patient));
    }

    @Test
    public void testClinicAddPhysiotherapist() {
        clinic.addPhysiotherapist(physio);
        assertTrue(clinic.getPhysiotherapists().contains(physio));
    }

   

    // Test: ReportGenerator (Assuming it generates a report string)
    @Test
    public void testGenerateReport() {
        String report = reportGenerator.generateAppointmentsReport(bookingSystem.getClinic().getPatients());
        assertNotNull(report);
        assertTrue(report.contains("John Doe"));
        assertTrue(report.contains("Back Pain"));
    }
}