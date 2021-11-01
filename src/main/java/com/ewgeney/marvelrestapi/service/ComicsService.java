package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.model.Comics;

import java.util.List;

public interface ComicsService {
    /**
     * Создает новый комикс
     * @param comics - комикс для создания
     */
    void create(Comics comics);

    /**
     * Возвращает список всех имеющихся комиксов
     * @return список комиксов
     */
    List<Comics> readAll();

    /**
     * Возвращает комикс по его ID
     * @param id - ID комикса
     * @return - объект комикса с заданным ID
     */
    Comics read(String id);

    /**
     * Обновляет комикс с заданным ID,
     * в соответствии с переданным комиксом
     * @param comics - комикс в соответсвии с которым нужно обновить данные
     * @param id - id комикса который нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Comics comics, String id);

    /**
     * Удаляет комикс с заданным ID
     * @param id - id комикса, который нужно удалить
     * @return - true если комикс был удален, иначе false
     */
    boolean delete(String id);
}

