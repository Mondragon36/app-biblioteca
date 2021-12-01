/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import clientes.AuthorClient;
import modelos.Author;

/**
 *
 * @author shurima
 */
public class CrudAuthorController {
    
    private AuthorClient client;

    public CrudAuthorController() {
        client=new AuthorClient();
    }
    
    public void createAuthor (long id,String lastName,String name) throws Exception{
        Author author = new Author(id,lastName,name);
        client.createAuhor(author);
    }
    
    
}
