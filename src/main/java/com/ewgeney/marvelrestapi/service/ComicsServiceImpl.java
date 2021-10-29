package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.controller.ComicsRepository;
import com.ewgeney.marvelrestapi.controller.MarvelRepository;
import com.ewgeney.marvelrestapi.model.Character;
import com.ewgeney.marvelrestapi.model.Comics;
import com.ewgeney.marvelrestapi.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicsServiceImpl implements ComicsService{

    @Autowired
    private ComicsRepository repository;
    @Override
    public void create(Comics comics) {
        repository.save(comics);
    }

    @Override
    public List<Comics> readAll() {
        return repository.findAll();
    }

    @Override
    public Comics read(String id) {
        return repository.findOneById(id);
    }

    @Override
    public boolean update(Comics comics, String id) {

        if(repository.existsById(id)){
            repository.deleteById(id);
            comics.setId(id);
            repository.insert(comics);
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
