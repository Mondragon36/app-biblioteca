/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author shurima
 */
public class Author {
    private long id;
    private String lastName;
    private String name;

    public Author() {
    }



    public Author(long id, String lastName, String name) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Author{" +
                "id=" + id + ","
                + " lastName=" + lastName + ","
                + " name=" + name + '}';
    }
    
    
    
}
