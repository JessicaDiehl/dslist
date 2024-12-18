package com.jessicadiehl.dslist.controller;

import com.jessicadiehl.dslist.dto.GameDTO;
import com.jessicadiehl.dslist.dto.GameMinDTO;
import com.jessicadiehl.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findbyId(@PathVariable Long id) {
        GameDTO result = gameService.findbyId(id);
        return result;
    }
}
