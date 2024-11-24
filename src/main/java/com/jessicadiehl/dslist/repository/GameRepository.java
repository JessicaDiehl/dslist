package com.jessicadiehl.dslist.repository;

import com.jessicadiehl.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
