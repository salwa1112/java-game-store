package com.salwa.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Class that represent an Entity Game
public class Game {
    //Declare properties
    private String id;

    private String name;

    private int price;

    //@NotNull
    private int QuantityStore;

    private ProducerCompany producerCompany;

    public Game() {
    }

    public Game(String name, int price, int quantityStore, ProducerCompany producerCompany) {
        this.name = name;
        this.price = price;
        QuantityStore = quantityStore;
        this.producerCompany = producerCompany;
    }

    public Game(String id, String name, int price, int quantityStore, ProducerCompany producerCompany) {
        this.id = id;
        this.name = name;
        this.price = price;
        QuantityStore = quantityStore;
        this.producerCompany = producerCompany;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return QuantityStore;
    }

    public void setQuantityStore(int quantityStore) {
        QuantityStore = quantityStore;
    }

    public ProducerCompany getProducerCompany() {
        return producerCompany;
    }

    public void setProducerCompany(ProducerCompany producerCompany) {
        this.producerCompany = producerCompany;
    }
}
