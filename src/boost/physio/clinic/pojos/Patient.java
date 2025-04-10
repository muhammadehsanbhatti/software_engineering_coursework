/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boost.physio.clinic.pojos;

/**
 *
 * @author ehsan
 */
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int id;
    private String name;
    private String address;
    private String phone;
    private List<Appointment> appointments;

    public Patient(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public String getName() {
        return name;
    }
}

