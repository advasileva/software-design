package org.example.bychatgpt;

import java.util.ArrayList;
import java.util.List;

//Game Console class
class GameConsole implements Subject {
    private List<Observer> observers;
    private String game;
    private String achievement;
    private String briefInfo;
    private String technicalData;

    public GameConsole() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(game, achievement, briefInfo, technicalData);
        }
    }

    public void releaseNewGame(String game, String achievement, String briefInfo, String technicalData) {
        this.game = game;
        this.achievement = achievement;
        this.briefInfo = briefInfo;
        this.technicalData = technicalData;

        notifyObservers();
    }
}
