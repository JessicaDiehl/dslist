package com.jessicadiehl.dslist.service;

import com.jessicadiehl.dslist.dto.GameDTO;
import com.jessicadiehl.dslist.dto.GameMinDTO;
import com.jessicadiehl.dslist.entities.Game;
import com.jessicadiehl.dslist.projections.GameMinProjection;
import com.jessicadiehl.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findbyId(@PathVariable Long listId) {
        Game result = gameRepository.findById(listId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGameList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList(); //converte um projection para DTO
    }
}
