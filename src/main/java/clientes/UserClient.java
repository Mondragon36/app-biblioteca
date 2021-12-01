/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import static clientes.PublisherClient.HOST;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.APIError;
import modelos.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author shurima
 */
public class UserClient {
    public static final String HOST = "https://biblioteca-eam.herokuapp.com";
    
    private ObjectMapper objectMapper;
    private OkHttpClient client;

    public UserClient() {
        objectMapper = new ObjectMapper();
        client = new OkHttpClient().newBuilder().build();    
    }
    
    public void createUser (User user) throws Exception{
         String bodyStr = objectMapper.writeValueAsString(user);
        
        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "{\n    \"id\": \""+person.getId()+"\",\n    \"name\": \""+person.getName()+"\",\n    \"age\": 30,\n    \"city\": \"Cali\"\n}");
        RequestBody body = RequestBody.create(mediaType, bodyStr);

        Request request = new Request.Builder()
        .url(HOST +"/users")
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
