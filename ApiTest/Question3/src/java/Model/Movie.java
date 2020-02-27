/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import javax.json.Json;
import javax.json.JsonObject;

public class Movie {

    private int id;
    private String title;
    private String category;
    private String renter = "";
    
    public Movie(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }
    
    public Movie(JsonObject json) {
        id = json.getInt("id", 0);
        title = json.getString("title", "");
        category = json.getString("category", "");     
    }
    
    public JsonObject toJson() {
    return Json.createObjectBuilder()
        .add("id", id)
        .add("title", title)
        .add("category", category)
        .add("renter", renter)
        .build();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
