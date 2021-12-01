/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author shurima
 */
public class User {
    private String identification;
    private String lastName;
    private String name;

    public User() {
    }

    
    public User(String identification, String lastName, String name) {
        this.identification = identification;
        this.lastName = lastName;
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "identification=" + identification + ", lastName=" + lastName + ", name=" + name + '}';
    }
    
    
}
