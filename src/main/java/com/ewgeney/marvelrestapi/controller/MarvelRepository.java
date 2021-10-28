package com.ewgeney.marvelrestapi.controller;

import com.ewgeney.marvelrestapi.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarvelRepository extends MongoRepository<Character, String> {
    /*@Autowired
    private MongoTemplate mongoTemplate;

    public List<Character> findAll() {
        return mongoTemplate.findAll(Character.class);
    }*/
}
