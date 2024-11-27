package com.jessicadiehl.dslist.controller;

import com.jessicadiehl.dslist.dto.GameListDTO;
import com.jessicadiehl.dslist.dto.GameMinDTO;
import com.jessicadiehl.dslist.service.GameListService;
import com.jessicadiehl.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable long listId) {
        List<GameMinDTO> result = gameService.findByGameList(listId);
        return result;
    }

}
