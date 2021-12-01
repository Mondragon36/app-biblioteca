/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import clientes.BookClient;
import clientes.PublisherClient;
import modelos.Book;
import modelos.Publisher;

/**
 *
 * @author shurima
 */
public class CrudBookController {
    private BookClient client;

    public CrudBookController() {
        client=new BookClient();
    }
    
    public void createBook(String code,String isbn_libro,String name,int stock,Publisher publisher) throws Exception{
        Book book= new Book(code,isbn_libro,name,stock,publisher);
        client.createBook(book,publisher.getCode());
        
    }  
    
   
    
    
}
