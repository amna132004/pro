/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import App.MenuEtudiant;

/**
 *
 * @author HP
 */
public class Etudiant extends User{

    public Etudiant(String name, String email) {
        super(name, email);
    }
    @Override
    public  String getRole(){
        return "Vous etes connecte en tant que Etudiant";
    }

@Override
    public void openDashboard() {
        new MenuEtudiant(this).setVisible(true);
    }
    @Override
    public String toString() {
        return "Etudiant{" + '}';
    }
    
}
