package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.model.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CharacterServiceImpl implements CharacterService {

    // Хранилище клиентов
    private static final Map<Integer, Character> CHARACTER_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    private static final AtomicInteger CHARACTER_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Character character) {
        final int characterId = CHARACTER_ID_HOLDER.incrementAndGet();
        character.setId(characterId);
        CHARACTER_REPOSITORY_MAP.put(characterId, character);
    }

    @Override
    public List<Character> readAll() {
        return new ArrayList<>(CHARACTER_REPOSITORY_MAP.values());
    }

    @Override
    public Character read(int id) {
        return CHARACTER_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Character character, int id) {
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