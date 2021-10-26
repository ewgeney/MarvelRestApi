package com.ewgeney.marvelrestapi.model;

import java.util.ArrayList;

public class Comics {
    private Integer id;
    private String name;
    private String description;
    private ArrayList<Integer> characterId;

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

    public ArrayList<Integer> getCharacterId() {
        return characterId;
    }

    public void setCharacterId(ArrayList<Integer> characterId) {
        this.characterId = characterId;
    }
}
