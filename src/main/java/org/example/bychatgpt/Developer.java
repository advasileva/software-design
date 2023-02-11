package org.example.bychatgpt;

//Developer class
class Developer implements Observer {
    private String game;
    private String technicalData;

    public void update(String game, String achievement, String briefInfo, String technicalData) {
        this.game = game;
        this.technicalData = technicalData;
        display();
    }

    public void display() {
        System.out.println("Game: " + game + ", Technical Data: " + technicalData);
    }
}
