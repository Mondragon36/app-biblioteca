/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author shurima
 */
public class Book {
    private String code;
    private String isbn_libro;
    private String name;
    private int stock;
    private Publisher publisher;

    public Book() {
    }
    
    

    public Book(String code, String isbn_libro, String name, int stock,Publisher publisher) {
        this.code = code;
        this.isbn_libro = isbn_libro;
        this.name = name;
        this.stock = stock;
        this.publisher=publisher;
    }

    @Override
    public String toString() {
        return "Book{" + "code=" + code + ", isbn_libro=" + isbn_libro + ", name=" + name + ", stock=" + stock + '}';
    }
    
    
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsbn_libro() {
        return isbn_libro;
    }

    public void setIsbn_libro(String isbn_libro) {
        this.isbn_libro = isbn_libro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   
    
    
}
