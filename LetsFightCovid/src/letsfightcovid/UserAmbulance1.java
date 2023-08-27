/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfightcovid;

/**
 *
 * @author User
 */
class UserAmbulance1 {
    
    private int ambulance_ID,hospital_ID,ambulance_availability;
    private String ambulance_contact,ambulance_rent;
    
    public UserAmbulance1(int ambulance_ID, int ambulance_availability, String ambulance_contact, String ambulance_rent, int hospital_ID )
    {
       this.ambulance_ID=ambulance_ID;
       this.ambulance_availability= ambulance_availability;
       this.ambulance_contact=ambulance_contact;
       this.ambulance_rent=ambulance_rent;
       this.hospital_ID=hospital_ID;
    
    }
    public int getambulance_ID(){
    return ambulance_ID;
    }
    public int getambulance_availability(){
    return  ambulance_availability;
    }
    public String getambulance_contact(){
    return ambulance_contact;
    }
    public String getambulance_rent(){
    return ambulance_rent;
    }
    public int gethospital_ID(){
    return hospital_ID;
    }
    
    
}
