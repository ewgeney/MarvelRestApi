package com.ewgeney.marvelrestapi.service;

import com.ewgeney.marvelrestapi.controller.ComicsRepository;
import com.ewgeney.marvelrestapi.model.Comics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicsServiceImpl implements ComicsService{

    @Autowired
    private ComicsRepository comicsRepository;
    @Override
    public void create(Comics comics) {
        comicsRepository.save(comics);
    }

    @Override
    public List<Comics> readAll() {
        return comicsRepository.findAll();
    }

    @Override
    public Comics read(String id) {
        return comicsRepository.findOneById(id);
    }

    @Override
    public boolean update(Comics comics, String id) {

        if(comicsRepository.existsById(id)){
            comicsRepository.deleteById(id);
            comics.setId(id);
            comicsRepository.insert(comics);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if(comicsRepository.existsById(id)){
            comicsRepository.deleteById(id);
            return true; }
        else return false;
    }
}
