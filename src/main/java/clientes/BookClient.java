/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import static clientes.PublisherClient.HOST;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import modelos.APIError;
import modelos.Book;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author shurima
 */
public class BookClient {
    public static final String HOST = "https://biblioteca-eam.herokuapp.com";
    
    private ObjectMapper objectMapper;
    private OkHttpClient client;

    public BookClient() {
        objectMapper = new ObjectMapper();
        client = new OkHttpClient().newBuilder().build();
    }
    
    public void createBook(Book book,String idPublisher) throws Exception{
        String bodyStr = objectMapper.writeValueAsString(book);
        
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, bodyStr);

        Request request = new Request.Builder()
        .url(HOST +"/books/"+idPublisher)
        .method("POST", body)
        .addHeader("Content-Type", "application/json")
        .build();
        
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        if (!response.isSuccessful()) {
           String bodyAsString = response.body().string();
           APIError error = objectMapper.readValue(bodyAsString, APIError.class);
           throw new Exception (error.getMessage());
        }
    }

    
}
