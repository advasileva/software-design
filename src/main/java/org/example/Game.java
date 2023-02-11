package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game implements Subject{
    private final List<Observer> observers;
    private String title;
    private String achievements;
    private String info;
    private String techData;

    public Game() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void releaseNewGame(String title, String achievements, String info, String techData) {
        this.title = title;
        this.achievements = achievements;
        this.info = info;
        this.techData = techData;

        notifyObservers();
    }

    public String getTitle() {
        return title;
    }

    public String getAchievements() {
        return achievements;
    }

    public String getInfo() {
        return info;
    }

    public String getTechData() {
        return techData;
    }
}
