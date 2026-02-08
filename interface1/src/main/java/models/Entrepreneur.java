/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import App.MenuEntrepreneur;

/**
 *
 * @author HP
 */
public class Entrepreneur extends User{
     public Entrepreneur(String name, String email) {
        super(name, email);
    }

    @Override
    public void openDashboard() {
        new MenuEntrepreneur(this).setVisible(true);
    }
     @Override
    public  String getRole(){
        return "Vous etes connecte en tant que Entrepreneur";
    }

    @Override
    public String toString() {
        return "Entrepreneur{" + '}';
    }
    
}
