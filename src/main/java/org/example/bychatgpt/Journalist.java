package org.example.bychatgpt;

//Journalist class
class Journalist implements Observer {
    private String game;
    private String briefInfo;

    public void update(String game, String achievement, String briefInfo, String technicalData) {
        this.game = game;
        this.briefInfo = briefInfo;
        display();
    }

    public void display() {
        System.out.println("Game: " + game + ", Brief Info: " + briefInfo);
    }
}
