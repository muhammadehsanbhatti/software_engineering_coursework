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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ehsan
 */
public class BoostPhysioClinic {

    /**
     * @param args the command line arguments
     */
     private static final Scanner scanner = new Scanner(System.in);
    private static final Clinic clinic = new Clinic();
    private static final BookingSystem bookingSystem = new BookingSystem(clinic);

    public static void main(String[] args) {
        initializeDummyData();

        while (true) {
            System.out.println("\n=== Boost Physio Clinic Booking System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Physiotherapist");
            System.out.println("3. Book Appointment by Expertise");
            System.out.println("4. Book Appointment by Physiotherapist Name");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. All Patient");
            System.out.println("7. All Physiotherapist");
            System.out.println("8. Generate Report");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addPhysiotherapist();
                case 3 -> bookByExpertise();
                case 4 -> bookByPhysiotherapistName();
                case 5 -> cancelAppointment();
                case 6 -> showAllPatients();
                case 7 -> showAllPhysiotherapist();
                case 8 -> generateReport();
                case 0 -> {
                    System.out.println("Exiting system.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
    
    private static void showAllPatients()
    {
        for(Patient patient : clinic.getPatients())
        {
            System.out.println(patient.toString());
        }
        
    }

    private static void showAllPhysiotherapist()
    {
        for(Physiotherapist physio : clinic.getPhysiotherapists())
        {
            System.out.println(physio.toString());
        }
    }
    private static void initializeDummyData() {
        Physiotherapist physio1 = new Physiotherapist(1, "Dr. Smith", "123456789", "Massage",
                List.of(new Treatment("Massage", null, "10:00 AM")));
        Physiotherapist physio2 = new Physiotherapist(2, "Dr. Brown", "987654321", "Rehabilitation",
                List.of(new Treatment("Rehabilitation", null, "2:00 PM")));
        clinic.addPhysiotherapist(physio1);
        clinic.addPhysiotherapist(physio2);

        Patient patient1 = new Patient(1, "John Doe", "New York", "111222333");
        clinic.addPatient(patient1);
    }

    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Patient patient = new Patient(id, name, address, phone);
        clinic.addPatient(patient);
        System.out.println("Patient added successfully.");
    }

    private static void addPhysiotherapist() {
        System.out.print("Enter Physiotherapist ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Area of Expertise: ");
        String expertise = scanner.nextLine();

        List<Treatment> treatments = new ArrayList<>();
        System.out.print("How many treatments? ");
        int tCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < tCount; i++) {
            System.out.print("Enter Treatment Name: ");
            String tName = scanner.nextLine();
            System.out.print("Enter Treatment Time: ");
            String tTime = scanner.nextLine();
            treatments.add(new Treatment(tName, null, tTime));
        }

        Physiotherapist physio = new Physiotherapist(id, name, phone, expertise, treatments);
        clinic.addPhysiotherapist(physio);
        System.out.println("Physiotherapist added successfully.");
    }

    private static void bookByExpertise() {
        System.out.print("Enter Area of Expertise: ");
        String expertise = scanner.nextLine();
        List<Physiotherapist> physios = clinic.findPhysiotherapistsByExpertise(expertise);

        if (physios.isEmpty()) {
            System.out.println("No physiotherapists found for this expertise.");
            return;
        }

        for (int i = 0; i < physios.size(); i++) {
            System.out.println((i + 1) + ". " + physios.get(i).getName());
        }

        System.out.print("Choose Physiotherapist by number: ");
        int physioIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Physiotherapist physio = physios.get(physioIndex);

        showTreatmentsAndBook(physio);
    }

    private static void bookByPhysiotherapistName() {
        System.out.print("Enter Physiotherapist Name: ");
        String name = scanner.nextLine();
        Physiotherapist physio = clinic.findPhysiotherapistByName(name);

        if (physio == null) {
            System.out.println("No such physiotherapist found.");
            return;
        }

        showTreatmentsAndBook(physio);
    }

    private static void showTreatmentsAndBook(Physiotherapist physio) {
        List<Treatment> treatments = physio.getTreatments();
        for (int i = 0; i < treatments.size(); i++) {
            Treatment t = treatments.get(i);
            System.out.println((i + 1) + ". " + t.getName() + " - " + t.getTimeSlot());
        }

        System.out.print("Choose treatment by number: ");
        int treatmentIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Treatment treatment = treatments.get(treatmentIndex);

        System.out.print("Enter Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        Patient patient = clinic.findPatientById(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        Appointment appointment = bookingSystem.bookAppointment(patient, physio, treatment, treatment.getTimeSlot());
        System.out.println("Appointment booked successfully: " + appointment.getStatus());
    }

    private static void cancelAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        Patient patient = clinic.findPatientById(patientId);

        if (patient == null || patient.getAppointments().isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (int i = 0; i < patient.getAppointments().size(); i++) {
            Appointment a = patient.getAppointments().get(i);
            System.out.println((i + 1) + ". " + a.getTreatment().getName() + " with " + a.getPhysiotherapist().getName() + " at " + a.getTimeSlot());
        }

        System.out.print("Choose appointment to cancel: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        Appointment appointment = patient.getAppointments().get(index);
        appointment.setStatus("Cancelled");
        System.out.println("Appointment cancelled.");
    }

    private static void generateReport() {
        List<Patient> patients = clinic.getPatients();
        String report = ReportGenerator.generateAppointmentsReport(patients);
        System.out.print(report);
    }
    
}
