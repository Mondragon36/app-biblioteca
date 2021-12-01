/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;

/**
 *
 * @author shurima
 */
public class BorrowRequest {
    private long idBorrow;
    private String idUser;
    private String idBook;

    public BorrowRequest() {
    }
    
    

    public BorrowRequest(long idBorrow, String idUser, String idBook) {
        this.idBorrow = idBorrow;
        this.idUser = idUser;
        this.idBook = idBook;
    }

    @Override
    public String toString() {
        return "BorrowRequest{" + "idBorrow=" + idBorrow + ", idUser=" + idUser + ", idBook=" + idBook + '}';
    }

    public long getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(long idBorrow) {
        this.idBorrow = idBorrow;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

}