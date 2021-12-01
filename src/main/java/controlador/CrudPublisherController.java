/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import clientes.PublisherClient;
import modelos.Publisher;

/**
 *
 * @author shurima
 */
public class CrudPublisherController {
    private PublisherClient client;

    public CrudPublisherController() {
        client=new PublisherClient();

    }
    
    public void createPublisher (String code,String name) throws Exception{
        Publisher publisher = new Publisher(code,name);
        client.createPublisher(publisher);
    }
    
     public Publisher getPublisher(String idPublisher) throws Exception{
        return client.findPublisher(idPublisher);
    }
    
    
}
