/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import clientes.BorrowClient;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import modelos.Book;
import modelos.BorrowRequest;

/**
 *
 * @author shurima
 */
public class CrudBorrowController {

    private BorrowClient client;

    public CrudBorrowController() {
        client = new BorrowClient();
    }

    public void createBorrow(long idBorrow, String idUser, String idBook) throws Exception {
        BorrowRequest borrowRquest = new BorrowRequest(idBorrow, idUser, idBook);
        client.createBorrow(borrowRquest);
    }

    public void deliveryBook(long idBorrow, String idUser, String idBook) throws Exception {
        BorrowRequest borrowRequest = new BorrowRequest(idBorrow,idUser,idBook);
        client.deliveryBook(borrowRequest);    
    }
    
    public List<Book> getBooksByUser(String idUser) throws IOException{
        return client.findBooksByUser(idUser);
    }

}
