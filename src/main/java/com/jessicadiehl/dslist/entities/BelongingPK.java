package com.jessicadiehl.dslist.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

}
