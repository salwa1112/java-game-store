package com.salwa;

import com.salwa.model.Game;

import java.util.List;

public interface GameManage {
    void add(Game witcher);

    List<Game> getGame();

    void delete(Game witcher);
}
