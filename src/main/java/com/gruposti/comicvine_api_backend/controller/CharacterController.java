package com.gruposti.comicvine_api_backend.controller;


import com.gruposti.comicvine_api_backend.model.CharacterDetailsResponseDTO;
import com.gruposti.comicvine_api_backend.model.CharacterListResponseDTO;
import com.gruposti.comicvine_api_backend.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<CharacterListResponseDTO> getCharacters(@RequestParam(required = false) Integer limit) {
        if (limit == null) {
            limit = 25;
        }
        CharacterListResponseDTO response = characterService.getCharacters(limit);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public CharacterDetailsResponseDTO getCharacterDetails(@PathVariable String id) {
        return characterService.getCharacterDetails(id);
    }
}
