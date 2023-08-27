/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfightcovid;

/**
 *
 * @author Asus
 */
class UserPlasma {
    
    private int plasma_ID;
    private String donor_name,donor_address,blood_group,donor_contact;
    private int plasma_availability;
    
    public UserPlasma(int plasma_ID, String donor_name, String donor_address, String blood_group, String donor_contact, int plasma_availability) {
        this.plasma_ID = plasma_ID;
        this.donor_name = donor_name;
        this.donor_address = donor_address;
        this.blood_group = blood_group;
        this.donor_contact = donor_contact;
        this.plasma_availability = plasma_availability;
    }

    public int getPlasma_ID() {
        return plasma_ID;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public String getDonor_address() {
        return donor_address;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public String getDonor_contact() {
        return donor_contact;
    }

    public int getPlasma_availability() {
        return plasma_availability;
    }

    
    
}
