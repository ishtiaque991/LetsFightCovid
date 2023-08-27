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
class UserOxygen {
    
    private int provider_ID;
    private String provider_address, provider_contact;
    private int available_stock;
    private String price_per_cylinder;
    
    public UserOxygen(int provider_ID, String provider_address, String provider_contact, int available_stock, String price_per_cylinder) {
        this.provider_ID = provider_ID;
        this.provider_address = provider_address;
        this.provider_contact = provider_contact;
        this.available_stock = available_stock;
        this.price_per_cylinder = price_per_cylinder;
    }

    public int getProvider_ID() {
        return provider_ID;
    }

    public String getProvider_address() {
        return provider_address;
    }

    public String getProvider_contact() {
        return provider_contact;
    }

    public int getAvailable_stock() {
        return available_stock;
    }

    public String getPrice_per_cylinder() {
        return price_per_cylinder;
    }

    
    
}
