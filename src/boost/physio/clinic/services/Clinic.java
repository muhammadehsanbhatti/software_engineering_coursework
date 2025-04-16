/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boost.physio.clinic.services;

import boost.physio.clinic.pojos.Patient;
import boost.physio.clinic.pojos.Physiotherapist;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahsan
 */
public class Clinic {
    private List<Patient> patients;
    private List<Physiotherapist> physiotherapists;

    public Clinic() {
        patients = new ArrayList<>();
        physiotherapists = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.getName());
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
        System.out.println("Patient removed: " + patient.getName());
    }

    public void addPhysiotherapist(Physiotherapist physio) {
        physiotherapists.add(physio);
        System.out.println("Physiotherapist added: " + physio.getName());
    }

    public List<Physiotherapist> searchPhysiotherapistsByExpertise(String expertise) {
        List<Physiotherapist> results = new ArrayList<>();
        for (Physiotherapist physio : physiotherapists) {
            if (physio.getExpertise().equalsIgnoreCase(expertise)) {
                results.add(physio);
            }
        }
        return results;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Physiotherapist> getPhysiotherapists() {
        return physiotherapists;
    }

    public void setPhysiotherapists(List<Physiotherapist> physiotherapists) {
        this.physiotherapists = physiotherapists;
    }
    
    public List<Physiotherapist> findPhysiotherapistsByExpertise(String expertise) {
    List<Physiotherapist> matchingPhysios = new ArrayList<>();
    for (Physiotherapist physio : physiotherapists) {
        if (physio.getExpertise().equalsIgnoreCase(expertise)) {
            matchingPhysios.add(physio);
        }
    }
    return matchingPhysios;
}
    public Physiotherapist findPhysiotherapistByName(String name) {
    for (Physiotherapist physio : physiotherapists) {
        if (physio.getName().equalsIgnoreCase(name)) {
            return physio;
        }
    }
    return null; // not found
}
    
    public Patient findPatientById(int id) {
    for (Patient patient : patients) {
        if (patient.getId() == id) {
            return patient;
        }
    }
    return null; // Not found
}
}
