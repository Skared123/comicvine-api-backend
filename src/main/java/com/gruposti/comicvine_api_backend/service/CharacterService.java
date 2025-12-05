package com.gruposti.comicvine_api_backend.service;

import com.gruposti.comicvine_api_backend.client.ComicVineClient;
import com.gruposti.comicvine_api_backend.client.response.ComicVineCharacterResponse;
import com.gruposti.comicvine_api_backend.model.CharacterListResponseDTO;
import com.gruposti.comicvine_api_backend.model.CharacterListResponseDTO.Character;
import com.gruposti.comicvine_api_backend.model.CharacterListResponseDTO.CharacterListData;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    private final ComicVineClient comicVineClient;

    public CharacterService(ComicVineClient comicVineClient) {
        this.comicVineClient = comicVineClient;
    }

    public CharacterListResponseDTO getCharacters(int limit) {

        String resourcePath = "/characters/";

        ComicVineCharacterResponse externalResponse = comicVineClient.buildRequest(resourcePath, limit)
                .retrieve()
                .bodyToMono(ComicVineCharacterResponse.class)
                .block();

        if (externalResponse == null || externalResponse.getResults() == null) {
            throw new RuntimeException("Error: No se recibió respuesta válida de Comic Vine.");
        }

        List<Character> characters = externalResponse.getResults().stream()
                .map(result -> {
                    Character character = new Character();
                    character.setId(result.getId());
                    character.setName(result.getName());
                    character.setDescription(result.getDeck());

                    if (result.getImage() != null) {
                        character.setImage(result.getImage().getSuper_url());
                    }
                    return character;
                })
                .collect(Collectors.toList());

        CharacterListData characterListData = new CharacterListData();
        characterListData.setItems(characters.size());
        characterListData.setCharacters(characters);

        CharacterListResponseDTO finalResponse = new CharacterListResponseDTO();
        finalResponse.setData(characterListData);

        return finalResponse;
    }
}
