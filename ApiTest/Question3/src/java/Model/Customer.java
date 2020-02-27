/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.json.Json;
import javax.json.JsonObject;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int movieId;

    public Customer(int id, String firstName, String lastName, int movieId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movieId = movieId;
    }
    
    public Customer(JsonObject json) {
        id = json.getInt("id", 0);
        firstName = json.getString("firstName", "");
        lastName = json.getString("lastName", "");
        movieId = json.getInt("movieId", 0);        
    }
    
    public JsonObject toJson() {
    return Json.createObjectBuilder()
                .add("id", id)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("movieId", movieId)
                .build();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    


}
