package org.example;

public class Developer implements Observer {
    private Game game;

    public Developer(Game game) {
        this.game = game;
    }

    @Override
    public void update() {
        System.out.println(String.format("TechData: %s", game.getTechData()));
    }
}
