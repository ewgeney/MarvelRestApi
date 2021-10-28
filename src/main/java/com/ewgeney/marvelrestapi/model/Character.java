package com.ewgeney.marvelrestapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

@Document
public class Character {
    @Id
    private String id;
    private String name;
    private String description;
    private ArrayList<Integer> comicsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getComicsId() {
        return comicsId;
    }

    public void setComicsId(ArrayList<Integer> comicsId) {
        this.comicsId = comicsId;
    }
}