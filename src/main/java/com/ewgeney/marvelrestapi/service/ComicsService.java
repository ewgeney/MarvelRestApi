package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.model.Comics;
import com.ewgeney.marvelrestapi.model.Model;

import java.util.List;

public interface ComicsService {
    /**
     * Создает новый комикс
     * @param comics - комикс для создания
     */
    void create(Comics comics);

    /**
     * Возвращает список всех имеющихся персонажей
     * @return список персонажей
     */
    List<Comics> readAll();

    /**
     * Возвращает персонажа по его ID
     * @param id - ID персонажа
     * @return - объект персонажа с заданным ID
     */
    Comics read(String id);

    /**
     * Обновляет персонажа с заданным ID,
     * в соответствии с переданным персонажем
     * @param comics - персонаж в соответсвии с которым нужно обновить данные
     * @param id - id персонажа которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Comics comics, String id);

    /**
     * Удаляет персонажа с заданным ID
     * @param id - id персонажа, которого нужно удалить
     * @return - true если персонаж был удален, иначе false
     */
    boolean delete(String id);
}

