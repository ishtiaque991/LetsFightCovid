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
class UserPayment {

    
    
    private int ID,subtotal,pay,bal;
            
    public UserPayment(int ID, int subtotal, int pay, int bal) {
        this.ID = ID;
        this.subtotal = subtotal;
        this.pay = pay;
        this.bal = bal;
    }

    public int getID() {
        return ID;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getPay() {
        return pay;
    }

    public int getBal() {
        return bal;
    }
    
    
}
