/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author HP
 */
public abstract class Project {
    protected String title;
    protected String description;
    protected User owner;

    public Project(String title, String description, User owner) {
        this.title = title;
        this.description = description;
        this.owner = owner;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public User getOwner() { return owner; }

    public abstract String getType();

    @Override
    public String toString() {
        return "Project{" + "title=" + title + ", description=" + description + ", owner=" + owner + '}';
    }
    
}
