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
class UserIcu1 {
    private int icu_ID,hospital_ID,icu_availability;
    private String cost_per_day;
    
    public UserIcu1(int icu_ID, int icu_availability, String cost_per_day, int hospital_ID )
    {
       this.icu_ID=icu_ID;
       this.icu_availability= icu_availability;
       this.cost_per_day=cost_per_day;
       this.hospital_ID=hospital_ID;
    
    }
    public int geticu_ID(){
    return icu_ID;
    }
    public int geticu_availability(){
    return  icu_availability;
    }
    public String getcost_per_day(){
    return cost_per_day;
    }
    public int gethospital_ID(){
    return hospital_ID;
    }
    
    
}
