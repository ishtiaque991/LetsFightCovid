/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfightcovid;

/**
 *
 * @author USER
 */
class UserVaccine1 {
    private int center_ID;
    private String hospital_name, center_location, available_vaccine;
    
    public UserVaccine1(int center_ID, String hospital_name, String center_location, String available_vaccine )
    {
        this.center_ID=center_ID;
        this.hospital_name=hospital_name;
        this.center_location=center_location;
        this.available_vaccine=available_vaccine;
    }
    public int getcenter_ID(){
        return center_ID;
    }
    public String gethospital_name(){
        return hospital_name;
    }
    public String getcenter_location(){
        return center_location;
    }
    public String getavailable_vaccine(){
        return available_vaccine;
    }
}
