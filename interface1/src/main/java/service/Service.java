/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import models.*;

/**
 *
 * @author HP
 */
public class Service {
    public static ArrayList<StartUp> startupIdeas = new ArrayList<>();
    public static ArrayList<SmallBusiness> smallBusinesses = new ArrayList<>();

    public static void addStartupIdea(StartUp idea) {
        startupIdeas.add(idea);
    }

    public static void addSmallBusiness(SmallBusiness sb) {
        smallBusinesses.add(sb);
    }
    
     public static StartUp findStartupByTitle(String title) {
        for (StartUp s : startupIdeas) {
            if (s.getTitle().equalsIgnoreCase(title.trim())) {
                return s;
            }
        }
        return null;
    }
    public static void invest(Investisseur investor, String title, double montant)
         {
        try {
        if (investor == null) {
            throw new IllegalArgumentException("Investisseur non valide");
        }

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Titre de startup invalide");
        }

        if (montant <= 0) {
            throw new IllegalArgumentException("Montant invalide");
        }

        StartUp s = findStartupByTitle(title);
        if (s == null) {
            throw new IllegalArgumentException("Startup introuvable");
        }

        s.addInvestment(investor, montant);

    } catch (IllegalArgumentException e) {
        throw e; // on laisse la vue gérer l'affichage
    }
  }
    
    public  static ArrayList<StartUp> searchStartupsWithFreeSkill(String skill) {
    ArrayList<StartUp> results = new ArrayList<>();

    for (StartUp s : startupIdeas) {
        if (s.getSkillsMap().containsKey(skill)      // startup contient ce skill
            && s.getSkillsMap().get(skill) == null)  // skill pas encore assigné
        {
            results.add(s);
        }
    }

    return results;
}
    public static void joinStartup(
            Etudiant etudiant,
            String startupTitle,
            String skill) {

        if (skill == null || skill.trim().isEmpty()) {
            throw new IllegalArgumentException("Skill invalide");
        }

        StartUp s = findStartupByTitle(startupTitle);
        if (s == null) {
            throw new IllegalArgumentException("Startup introuvable");
        }

        if (!s.hasSkill(skill)) {
            throw new IllegalArgumentException("Skill non requis par cette startup");
        }

        if (!s.isSkillFree(skill)) {
            throw new IllegalArgumentException("Skill déjà pris");
        }

        s.assignStudent(skill, etudiant);
    }
}
