/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import static clientes.AuthorClient.HOST;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import modelos.APIError;
import modelos.Publisher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author shurima
 */
public class PublisherClient {

    public static final String HOST = "https://biblioteca-eam.herokuapp.com";

    private ObjectMapper objectMapper;
    private OkHttpClient client;

    public PublisherClient() {
        objectMapper = new ObjectMapper();
        client = new OkHttpClient().newBuilder().build();

    }

    public void createPublisher(Publisher publisher) throws Exception {
        String bodyStr = objectMapper.writeValueAsString(publisher);

        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "{\n    \"id\": \""+person.getId()+"\",\n    \"name\": \""+person.getName()+"\",\n    \"age\": 30,\n    \"city\": \"Cali\"\n}");
        RequestBody body = RequestBody.create(mediaType, bodyStr);

        Request request = new Request.Builder()
                .url(HOST + "/publishers")
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

    public Publisher findPublisher(String idPublisher) throws Exception {
        Request request = new Request.Builder()
        .url(HOST +"/publishers/"+idPublisher)
        .method("GET", null)
        .addHeader("Content-Type", "application/json")
           .build();
        Response response = client.newCall(request).execute();
        String bodyAsString = response.body().string();        
        if (response.isSuccessful()) {
            Publisher publisher = objectMapper.readValue(bodyAsString, Publisher.class);
            return publisher;
        } else {
            APIError error = objectMapper.readValue(bodyAsString, APIError.class);
            throw new Exception(error.getMessage());
        }
        
    }

}
