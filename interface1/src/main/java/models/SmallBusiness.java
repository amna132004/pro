/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class SmallBusiness extends Project{
     /*private double investment;*/
    private ArrayList<Investisseur> investors = new ArrayList<>();

    public SmallBusiness(String title, String description, Entrepreneur owner, ArrayList<Investisseur> investors) {
        super(title, description, owner);
        this.investors=investors;
    }

    public void addInvestor(Investisseur i) {
        investors.add(i);
    }

    @Override
    public String getType() {
        return "Small Business";
    }

    @Override
    public String toString() {
        return "SmallBusiness{"  +"Title : "+super.title +" Description :" +super.description + ", investors=" + investors + '}';
    }
    
}
