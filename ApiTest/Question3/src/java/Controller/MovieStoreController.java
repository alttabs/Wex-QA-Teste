/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

public class MovieStoreController {
    List<Movie> movieList;
    List<Customer> customerList;
    
    public MovieStoreController(){
        retrieveAllInformation();
    }
    
    public void retrieveAllInformation(){
        movieList = new ArrayList<>();
        movieList.add(new Movie(1, "ASSASSINS CREED: EMBERS", "Animations"));
        movieList.add(new Movie(2, "Real Steel(2012)", "Animations"));
        movieList.add(new Movie(3, "Alvin and the Chipmunks", "Animations"));
        movieList.add(new Movie(4, "The Adventures of Tin Tin", "Animations"));
        movieList.add(new Movie(5, "Safe (2012)", "Action"));
        movieList.add(new Movie(6, "Safe House(2012)", "Action"));
        movieList.add(new Movie(7, "GIA", "18+"));
        movieList.add(new Movie(8, "Deadline 2009", "18+"));
        movieList.add(new Movie(9, "The Dirty Picture", "18+"));
        movieList.add(new Movie(10, "Marley and me", "Romance"));
        
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Adam", "Smith", 1));
        customerList.add(new Customer(2, "Ravi", "Kumar", 2));
        customerList.add(new Customer(3, "Susan", "Davidson", 5));
        customerList.add(new Customer(4, "Jenny", "Adrianna", 8));
        customerList.add(new Customer(6, "Lee", "Pong", 10));
    }
    
    public JsonArray getAllMoviesJson() {
        for(Customer customer : customerList){
            for(Movie movie : movieList){
                if(customer.getMovieId() == movie.getId()){
                    movie.setRenter(customer.getFirstName() + " " + customer.getLastName());
                }
            }
        }
        
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        for(Movie movie : movieList){
            System.out.println("-------------");
            System.out.println(movie.getCategory());
            System.out.println(movie.getId());
            System.out.println(movie.getRenter());
            System.out.println(movie.getTitle());
            jsonArray.add(movie.toJson());
        }
        return jsonArray.build();
    }
    
    public JsonArray getByIdJson(int id) {
       
        Customer customer = null;
        for (Customer c : customerList) {
            if (c.getId() == id) {
                customer = c;
            }
        }
        
        Movie rentedMovie = null;
        for(Movie movie : movieList){
            if(customer.getMovieId() == movie.getId()){
                rentedMovie = movie;
            }
        }

        JsonArrayBuilder json = Json.createArrayBuilder();
        json.add(customer.toJson());
        json.add(rentedMovie.toJson());
        
        return json.build();
    }
}
