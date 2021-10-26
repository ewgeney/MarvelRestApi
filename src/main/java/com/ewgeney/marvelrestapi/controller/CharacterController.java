package com.ewgeney.marvelrestapi.controller;

import com.ewgeney.marvelrestapi.model.Character;
import com.ewgeney.marvelrestapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
    @PostMapping(value = "/v1/public/characters")
    public ResponseEntity<?> create(@RequestBody Character character) {
        characterService.create(character);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/v1/public/characters")
    public ResponseEntity<List<Character>> read() {
        final List<Character> characters = characterService.readAll();

        return characters != null &&  !characters.isEmpty()
                ? new ResponseEntity<>(characters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/v1/public/characters/{characterId}")
    public ResponseEntity<Character> read(@PathVariable(name = "characterId") int id) {
        final Character character = characterService.read(id);

        return character != null
                ? new ResponseEntity<>(character, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/v1/public/characters/{characterId}")
    public ResponseEntity<?> update(@PathVariable(name = "characterId") int id, @RequestBody Character character) {
        final boolean updated = characterService.update(character, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/v1/public/characters/{characterId}")
    public ResponseEntity<?> delete(@PathVariable(name = "characterId") int id) {
        final boolean deleted = characterService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
