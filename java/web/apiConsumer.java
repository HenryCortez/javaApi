/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buscador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;

/**
 *
 * @author henry
 */
public class apiConsumer {
    final static String BASE_URL = "http://localhost/Quinto/clase/controllers/apiRest.php";
    
    public static List<Student> buscarEstudiante(String id) throws UnirestException{
        JsonNode json = Unirest.get(BASE_URL)
                .queryString("id", id)
                .asJson()
                .getBody();
        String algo = json.toString();
        Gson jso = new Gson();
        return jso.fromJson(algo, new TypeToken<List<Student>>(){}.getType());
    }
}
