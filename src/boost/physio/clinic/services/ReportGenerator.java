/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boost.physio.clinic.services;

import boost.physio.clinic.pojos.Appointment;
import boost.physio.clinic.pojos.Patient;
import boost.physio.clinic.pojos.Physiotherapist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ehsan
 */
public class ReportGenerator {
    public static String generateAppointmentsReport(List<Patient> patients) {
        String report = "\n---- Appointments Report ----\n";
        
        for (Patient patient : patients) {
            for (Appointment appointment : patient.getAppointments()) {
                report = report + appointment.getDetails();
                
            }
        }
        return report;
    }

    public static void generatePhysiotherapistRanking(List<Physiotherapist> physiotherapists, List<Patient> patients) {
        Map<String, Integer> ranking = new HashMap<>();

        for (Patient patient : patients) {
            for (Appointment appointment : patient.getAppointments()) {
                if (appointment.getStatus().equals("Attended")) {
                    ranking.put(appointment.getPhysiotherapist().getName(),
                        ranking.getOrDefault(appointment.getPhysiotherapist().getName(), 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedRanking = new ArrayList<>(ranking.entrySet());
        sortedRanking.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\n---- Physiotherapist Rankings ----");
        for (Map.Entry<String, Integer> entry : sortedRanking) {
            System.out.println(entry.getKey() + " - Attended Appointments: " + entry.getValue());
        }
    }
}
