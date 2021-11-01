package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.controller.CharacterRepository;
import com.ewgeney.marvelrestapi.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Override
    public void create(Character character) {
        characterRepository.save(character);
    }

    @Override
    public List<Character> readAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character read(String id) {
        return characterRepository.findOneById(id);
    }

    @Override
    public boolean update(Character character, String id) {

        if(characterRepository.existsById(id)){
            characterRepository.deleteById(id);
            character.setId(id);
            characterRepository.insert(character);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if(characterRepository.existsById(id)){
        characterRepository.deleteById(id);
        return true; }
        else return false;
    }
}