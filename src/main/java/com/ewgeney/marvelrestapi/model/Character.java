package com.ewgeney.marvelrestapi.model;

import java.util.ArrayList;

public class Character {
    private Integer id;
    private String name;
    private String description;
    private ArrayList<Integer> comicsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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