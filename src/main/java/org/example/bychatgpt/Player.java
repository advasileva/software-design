package org.example.bychatgpt;

//Player class
class Player implements Observer {
    private String game;
    private String achievement;

    public void update(String game, String achievement, String briefInfo, String technicalData) {
        this.game = game;
        this.achievement = achievement;
        display();
    }

    public void display() {
        System.out.println("Game: " + game + ", Achievement: " + achievement);
    }
}
