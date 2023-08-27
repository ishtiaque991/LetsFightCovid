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
class User1 {
    private int hospital_ID;
    private String hospital_Name,hospital_address,hospital_contact;
    
    public User1(int hospital_ID, String hospital_Name, String hospital_address, String hospital_contact)
    {
       this.hospital_ID=hospital_ID;
       this.hospital_Name=hospital_Name;
       this.hospital_address=hospital_address;
       this.hospital_contact=hospital_contact;
    
    }
    public int gethospital_ID(){
    return hospital_ID;
    }
    public String gethospital_Name(){
    return hospital_Name;
    }
    public String gethospital_address(){
    return hospital_address;
    }
    public String gethospital_contact(){
    return hospital_contact;
    }
    
}
