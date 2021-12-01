/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import static clientes.BookClient.HOST;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.io.IOException;
import modelos.APIError;
import modelos.Book;
import modelos.BorrowRequest;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author shurima
 */
public class BorrowClient {

    public static final String HOST = "https://biblioteca-eam.herokuapp.com";

    private ObjectMapper objectMapper;
    private OkHttpClient client;

    public BorrowClient() {
        objectMapper = new ObjectMapper();
        client = new OkHttpClient().newBuilder().build();
    }

    public void createBorrow(BorrowRequest borrowRequest) throws Exception {
        String bodyStr = objectMapper.writeValueAsString(borrowRequest);

        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "{\n  \"idBorrow\": "+borrowRequest.getIdBorrow()+",\n  \"idUser\": \""+borrowRequest.getIdUser()+"\",\n    \"idBook\": \""+borrowRequest.getIdBook()+"\"\n}");
        RequestBody body = RequestBody.create(mediaType, bodyStr);

        Request request = new Request.Builder()
                .url(HOST + "/borrows/create")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        if (!response.isSuccessful()) {
            String bodyAsString = response.body().string();
            APIError error = objectMapper.readValue(bodyAsString, APIError.class);
            throw new Exception(error.getMessage());
        }
    }

    public void deliveryBook(BorrowRequest borrowRequest) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String bodyStr = objectMapper.writeValueAsString(borrowRequest);
        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "{\r\n    \"idBorrow\":1,\r\n    \"idUser\":\"123456\",\r\n    \"idBook\":\"00001\"\r\n}");
        RequestBody body = RequestBody.create(mediaType, bodyStr);
        Request request = new Request.Builder()
                .url(HOST + "/borrows/delete")
                .method("DELETE", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        if (!response.isSuccessful()) {
            String bodyAsString = response.body().string();
            APIError error = objectMapper.readValue(bodyAsString, APIError.class);
            throw new Exception(error.getMessage());
        }
    }

    public List<Book> findBooksByUser(String idUser) throws IOException{
        Request request = new Request.Builder()
                .url(HOST +"/borrows/books/"+idUser)
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        String bodyAsString = response.body().string();

        Book[] books = objectMapper.readValue(bodyAsString, Book[].class);

        return List.of(books);
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(HOST+"/books/"+idUser)
//                .method("GET", null)
//                .build();
//        Response response = client.newCall(request).execute();
//        String bodyAsString = response.body().string();
//        Book[] books = objectMapper.readValue(bodyAsString, Book[].class);
//
//        return List.of(books);
    }

}
