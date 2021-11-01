package com.ewgeney.marvelrestapi.controller;

import com.ewgeney.marvelrestapi.model.Comics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ComicsRepository extends MongoRepository<Comics, String> {
        Comics findOneById (String id);
    }


