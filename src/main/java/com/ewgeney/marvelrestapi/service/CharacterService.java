package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.model.Character;
import java.util.List;

public interface CharacterService {
    /**
     * Создает нового персонажа
     * @param character - персонаж для создания
     */
    void create(Character character);

    /**
     * Возвращает список всех имеющихся персонажей
     * @return список персонажей
     */
    List<Character> readAll();

    /**
     * Возвращает персонажа по его ID
     * @param id - ID персонажа
     * @return - объект персонажа с заданным ID
     */
    Character read(String id);

    /**
     * Обновляет персонажа с заданным ID,
     * в соответствии с переданным персонажем
     * @param character - персонаж в соответсвии с которым нужно обновить данные
     * @param id - id персонажа которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Character character, String id);

    /**
     * Удаляет персонажа с заданным ID
     * @param id - id персонажа, которого нужно удалить
     * @return - true если персонаж был удален, иначе false
     */
    boolean delete(String id);
}
