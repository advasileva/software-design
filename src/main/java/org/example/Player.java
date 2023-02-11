package org.example;

public class Player implements Observer {
    private Game game;

    public Player(Game game) {
        this.game = game;
    }

    @Override
    public void update() {
        System.out.println(String.format("Title: %s, achievements: %s", game.getTitle(), game.getAchievements()));
    }
}
