package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.controller.MarvelRepository;
import com.ewgeney.marvelrestapi.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private MarvelRepository repository;
    @Override
    public void create(Character character) {
        repository.save(character);
    }

    @Override
    public List<Character> readAll() {
        return repository.findAll();
    }

    @Override
    public Character read(String id) {
        return repository.findOneById(id);
    }

    @Override
    public boolean update(Character character, String id) {

        if(repository.existsById(id)){
            repository.deleteById(id);
            character.setId(id);
            repository.insert(character);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if(repository.existsById(id)){
        repository.deleteById(id);
        return true; }
        else return false;
    }
}