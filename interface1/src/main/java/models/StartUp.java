/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class StartUp extends Project{
    private ArrayList<String> requiredSkills = new ArrayList<>();
    private ArrayList<Etudiant> teamMembers = new ArrayList<>();
    private Map<String, Etudiant> skillsMap = new LinkedHashMap<>();
   /* private HashMap<String, String> assigned = new HashMap<>();*/
    private Map<Investisseur, Double> investissements = new LinkedHashMap<>();

    public StartUp(String title, String description, Entrepreneur owner, ArrayList<String> skillsList) {
        super(title, description, owner);
       for (String s : skillsList) {
            skillsMap.put(s, null);
        }
    }

    public void addSkill(String skill) {
        requiredSkills.add(skill);
    }
 public void addSkillmap(String skill) {
        skillsMap.put(skill, null); // pas encore assigné
    }

    public Map<String, Etudiant> getSkillsMap() {
        return skillsMap;
    }
 
    public void addTeamMember(Etudiant e) {
        teamMembers.add(e);
    }

    public ArrayList<String> getRequiredSkills() {
        return requiredSkills;
    }

    public ArrayList<Etudiant> getTeamMembers() {
        return teamMembers;
    }

  public void assignStudent(String skill, Etudiant etudiant) {
           if (!isSkillFree(skill)) {
            throw new IllegalStateException("Skill non disponible");
        }
           skillsMap.put(skill, etudiant);
    }
public boolean hasSkill(String skill) {
        return skillsMap.containsKey(skill);
    }
      public boolean isSkillFree(String skill) {
        return skillsMap.containsKey(skill) && skillsMap.get(skill)==null;
    }
public ArrayList<String> getFreeSkills() {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Etudiant> entry : skillsMap.entrySet()) {
            if (entry.getValue() == null) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

      public void addInvestment(Investisseur investor, double montant) {
    investissements.put(investor, montant);
}
      
      public Map<Investisseur, Double> getInvestissements() {
    return investissements;
}
      
    @Override
         public String getTitle() {
        return super.title;
    }
    @Override
    public String getType() {
        return "Startup";
    }

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(title).append("\n");
    sb.append("| Description : ").append(description).append("\n");
    sb.append("Owner : ").append(owner.getName()).append("\n");
    sb.append("Compétences requises :\n");

    for (Map.Entry<String, Etudiant> entry : skillsMap.entrySet()) {
        sb.append(" - ").append(entry.getKey()).append(" : ");
        sb.append(entry.getValue() == null ? "Libre" : entry.getValue().getName());
        sb.append("\n");
    }

    return sb.toString();
}
    /*@Override
    public String toString() {
        return super.title+ " | requiredSkills=" + requiredSkills + ", teamMembers=" + teamMembers + '}';
    }*/
    
}
