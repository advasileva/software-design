package org.example.bychatgpt;

//Main class
public class Main {
    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();

        Player player = new Player();
        Journalist journalist = new Journalist();
        Developer developer = new Developer();

        gameConsole.registerObserver(player);
        gameConsole.registerObserver(journalist);
        gameConsole.registerObserver(developer);

        gameConsole.releaseNewGame("Call of Duty", "Gold Medal", "Action-adventure video game", "High-end graphics");
    }
}
