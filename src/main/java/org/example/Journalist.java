package org.example;

public class Journalist implements Observer {
    private Game game;

    public Journalist(Game game) {
        this.game = game;
    }

    @Override
    public void update() {
        System.out.println(String.format("Info: %s", game.getInfo()));
    }
}
