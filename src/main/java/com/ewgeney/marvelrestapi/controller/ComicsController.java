package com.ewgeney.marvelrestapi.controller;

import com.ewgeney.marvelrestapi.model.Character;
import com.ewgeney.marvelrestapi.model.Comics;
import com.ewgeney.marvelrestapi.service.CharacterService;
import com.ewgeney.marvelrestapi.service.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComicsController {

    private final ComicsService comicsService;

    @Autowired
    public ComicsController(ComicsService comicsService) {
        this.comicsService = comicsService;
    }
    @PostMapping(value = "/v1/public/comics")
    public ResponseEntity<?> create(@RequestBody Comics comics) {
        comicsService.create(comics);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/v1/public/comics")
    public ResponseEntity<List<Comics>> read() {
        final List<Comics> comics = comicsService.readAll();

        return comics != null &&  !comics.isEmpty()
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/v1/public/comics/{comicId}")
    public ResponseEntity<Comics> read(@PathVariable(name = "comicId") String id) {
        final Comics comics = comicsService.read(id);

        return comics != null
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/v1/public/comics/{comicId}")
    public ResponseEntity<?> update(@PathVariable(name = "comicId") String id, @RequestBody Comics comics) {
        final boolean updated = comicsService.update(comics, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/v1/public/comics/{comicId}")
    public ResponseEntity<?> delete(@PathVariable(name = "comicId") String id) {
        final boolean deleted = comicsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
