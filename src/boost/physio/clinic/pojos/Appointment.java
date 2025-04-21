/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




package boost.physio.clinic.pojos;

/**
 *
 * @author ehsan
 */
public class Appointment {
    private Patient patient;
    private Physiotherapist physiotherapist;
    private Treatment treatment;
    private String timeSlot;
    private String status;

    public Appointment(Patient patient, Physiotherapist physiotherapist, Treatment treatment, String timeSlot) {
        this.patient = patient;
        this.physiotherapist = physiotherapist;
        this.treatment = treatment;
        this.timeSlot = timeSlot;
        this.status = "Booked";
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public void attend() {
        this.status = "Attended";
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return "Patient: " + patient.getName() + ", Treatment: " + treatment.getName() + ", Time: " + timeSlot + ", Status: " + status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(Physiotherapist physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
