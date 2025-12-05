package com.gruposti.comicvine_api_backend.controller;


import com.gruposti.comicvine_api_backend.model.CharacterListResponseDTO;
import com.gruposti.comicvine_api_backend.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<CharacterListResponseDTO> getCharacters(@RequestParam(defaultValue = "25") int limit) {
        CharacterListResponseDTO response = characterService.getCharacters(limit);

        return ResponseEntity.ok(response);
    }
}
