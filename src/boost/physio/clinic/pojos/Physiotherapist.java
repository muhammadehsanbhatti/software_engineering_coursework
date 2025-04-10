/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boost.physio.clinic.pojos;

import java.util.List;

/**
 *
 * @author ehsan
 */
public class Physiotherapist {
  private int id;
    private String name;
    private String phone;
    private String expertise;
    private List<Treatment> treatments;

    public Physiotherapist(int id, String name, String phone, String expertise, List<Treatment> treatments) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.expertise = expertise;
        this.treatments = treatments;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }  
}
