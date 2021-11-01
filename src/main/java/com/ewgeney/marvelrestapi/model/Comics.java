package com.ewgeney.marvelrestapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document
public class Comics {
    @Id
    private String id;
    private String name;
    private String description;
    private String posterUrl;
    private ArrayList<String> characterId;

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

    public String getCharacterId() {
        StringBuilder sb = new StringBuilder();
        for (Object o : characterId){
            sb.append(o.toString()+", ");
        }
        return sb.toString();
    }

    public void setCharacterId(ArrayList<String> s) {
        this.characterId.addAll(s);
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
