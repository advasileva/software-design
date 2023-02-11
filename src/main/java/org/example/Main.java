package org.example;

// Спроектировать систему используя паттерн Observer для игровой консоли.
// Каждый раз, как выходит новая игра, все игроки, журналисты и разработчики
// должны быть уведомлены о выходе нового тайтла,
// при этом игроки должны выводить название и достижения из игры,
// журналисты краткую информацию о игре,
// разработчики технические данные о игре.

import java.util.Arrays;
import java.util.List;

// Из интереса скормила это задание ChatGPT, её вариант в пакете bychatgpt,
// как мне кажется, выглядит неплохо)
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        List<Observer> users = Arrays.asList(
                new Player(game),
                new Journalist(game),
                new Developer(game)
        );

        for (Observer observer : users) {
            game.attach(observer);
        }

        game.releaseNewGame(
                "Reversi",
                "Played to the end",
                "Copyright (c) 2022 Alena Vasileva",
                "v0.0.1"
        );
    }
}