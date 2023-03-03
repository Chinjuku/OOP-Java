/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author LAB203_50
 */
public class Seller extends Employee{
    public Food sell(Employee e){
        Food f1 = new Food();
        if (e.getWallet().getBalance() > Food.getPrice()){
            this.getWallet().setBalance(getWallet() + Food.getPrice());
            return f1;
        }
    }
}
