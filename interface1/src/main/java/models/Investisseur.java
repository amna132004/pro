/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import App.MenuInvestisseur;

/**
 *
 * @author HP
 */
public class Investisseur extends User{
     public Investisseur (String name, String email) {
        super(name, email);
    }
 @Override
    public  String getRole(){
        return "Vous etes connecte en tant que Investisseur";
    }
    @Override
    public void openDashboard() {
        new MenuInvestisseur(this).setVisible(true);
    }
    
    @Override
    public String toString() {
        return "Investisseur{" + '}';
    }

    
}
