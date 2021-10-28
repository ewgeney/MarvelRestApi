package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.controller.MarvelRepository;
import com.ewgeney.marvelrestapi.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private MarvelRepository repository;

    // Хранилище персонажей
    private static final Map<String, Character> CHARACTER_REPOSITORY_MAP = new HashMap<String, Character>();

    // Переменная для генерации ID персонажа
    private static final AtomicInteger CHARACTER_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Character character) {
        repository.save(character);
    }

    @Override
    public List<Character> readAll() {
        return repository.findAll();
    }

    @Override
    public Character read(int id) {
        return CHARACTER_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Character character, String id) {
        if (CHARACTER_REPOSITORY_MAP.containsKey(id)) {
            character.setId(id);
            CHARACTER_REPOSITORY_MAP.put(id, character);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return CHARACTER_REPOSITORY_MAP.remove(id) != null;
    }
}