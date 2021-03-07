package com.salwa;

import com.salwa.model.Game;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@ApplicationScoped
public class GameStoreManagementService implements  GameManage{

    private List<Game> gameList = new ArrayList<>();

    public List<Game> getGameList() {
        return gameList;
    }

    @Override
    public void delete(@Observes @DeleteEvent Game witcher) {
        gameList.remove(witcher);
    }

    @Override
    public void add(@Observes @AddEvent Game witcher) {
        gameList.add(witcher);
    }


    @Override
    public List<Game> getGame() {
        return gameList;
    }


    private Boolean checkAndUpdateGameIfExit(Game game) {
        Optional<Game> gameOptional = this.gameList.stream().filter(g -> g.getName().equals(game.getName())).findFirst();
        if (gameOptional.isPresent()) {
            Game gameFounded = gameOptional.get();
            int index = gameList.indexOf(gameFounded);
            gameFounded.setQuantityStore(gameFounded.getQuantityStore() + game.getQuantityStore());
            gameList.set(index, gameFounded);
            return true;
        }
        return false;
    }
}

