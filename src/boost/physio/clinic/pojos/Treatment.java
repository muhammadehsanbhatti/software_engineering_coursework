/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boost.physio.clinic.pojos;

/**
 *
 * @author ehsan
 */
public class Treatment {
    private String name;
    private Physiotherapist physiotherapist;
    private String timeSlot;

    public Treatment(String name, Physiotherapist physiotherapist, String timeSlot) {
        this.name = name;
        this.physiotherapist = physiotherapist;
        this.timeSlot = timeSlot;
    }

    public String getName() {
        return name;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }
}
