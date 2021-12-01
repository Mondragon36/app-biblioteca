/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import clientes.UserClient;
import modelos.User;

/**
 *
 * @author shurima
 */
public class CrudUserController {
    private UserClient client;

    public CrudUserController() {
        client = new UserClient();
    }
    
    public void createUser(String identification,String lastName,String name) throws Exception{
        User user = new User(identification,lastName,name);
        client.createUser(user);
    }
}
