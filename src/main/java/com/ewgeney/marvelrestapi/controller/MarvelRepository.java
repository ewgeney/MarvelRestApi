package com.ewgeney.marvelrestapi.controller;

import com.ewgeney.marvelrestapi.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarvelRepository extends MongoRepository<Character, String> {
    Character findOneById (String id);
}
