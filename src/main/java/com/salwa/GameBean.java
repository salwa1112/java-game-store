package com.salwa;

import com.salwa.interceptor.Logged;
import com.salwa.model.Game;
import com.salwa.model.ProducerCompany;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class GameBean implements Serializable {
    private List<Game> games = new ArrayList<Game>();
    private List<SortMeta> sortBy;

    @Size(min = 3, max = 8)
    private String name;

    @Positive
    private int price;

    @Positive
    private int quantityStore;

    //Event of type Witcher
    @Inject
    @AddEvent
    private Event<Game> gameAddEvent;

//    @Inject
//    @DeleteEvent
//    private  Event<Game> gameDeleteEvent;


    private ProducerCompany producerCompany;

    @Inject
    private GameStoreManagementService gameStoreManagementService;

    @PostConstruct
    public void init() {
        sortBy = new ArrayList<>();
        sortBy.add(SortMeta.builder()
                .field("name")
                .order(SortOrder.ASCENDING)
                .build());
        sortBy.add(SortMeta.builder()
                .field("price")
                .order(SortOrder.ASCENDING)
                .priority(1)
                .build());
        sortBy.add(SortMeta.builder()
                .field("quantityStore")
                .order(SortOrder.ASCENDING)
                .priority(1)
                .build());
        sortBy.add(SortMeta.builder()
                .field("producerCompany")
                .order(SortOrder.ASCENDING)
                .priority(1)
                .build());
    }


    @Logged
    public void addGame() {
        //Add event
        Game newGame = new Game(name, price, quantityStore, producerCompany);
        gameStoreManagementService.add(newGame);
        //gameAddEvent.fire(newGame);
        blankTextBoxs();
    }

    /*
    public void removeGame(String gameId) {
        Game newGame = new Game(name, price, quantityStore, producerCompany);
        gameDeleteEvent.fire(newGame);
       // gameStoreManagementService.removeGame(gameId);
       // games = gameStoreManagementService.getGameList();
    }
    */

    private void blankTextBoxs() {
        name = "";
        price = 0;
        quantityStore = 0;
        producerCompany = null;
    }

    public List<Game> getGames() {
        games = gameStoreManagementService.getGameList();
        return games;
        //return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityStore() {
        return quantityStore;
    }

    public void setQuantityStore(int quantityStore) {
        this.quantityStore = quantityStore;
    }

    public ProducerCompany getProducerCompany() {
        return producerCompany;
    }

    public void setProducerCompany(ProducerCompany producerCompany) {
        this.producerCompany = producerCompany;

    }
}
