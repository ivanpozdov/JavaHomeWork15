package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin1(){
        Player Nikita = new Player(1, "Никита", 100);
        Player Andrey = new Player(2, "Андрей", 120);
        Game game = new Game();

        game.register(Nikita);
        game.register(Andrey);

        int actual = game.round("Андрей", "Никита");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenSecondPlayerWin2(){
        Player Nikita = new Player(1, "Никита", 120);
        Player Andrey = new Player(2, "Андрей", 100);
        Game game = new Game();

        game.register(Nikita);
        game.register(Andrey);

        int actual = game.round("Андрей", "Никита");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenPlayerDraw(){
        Player Nikita = new Player(1, "Никита", 120);
        Player Andrey = new Player(2, "Андрей", 120);
        Game game = new Game();

        game.register(Nikita);
        game.register(Andrey);

        int actual = game.round("Андрей", "Никита");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenFirstPlayerNotExist(){
        Player Nikita = new Player(1, "Никита", 100);
        Player Andrey = new Player(2, "Андрей", 120);
        Game game = new Game();

        game.register(Nikita);
        game.register(Andrey);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Рома", "Никита")
        );

    }
    @Test
    public void testWhenSecondPlayerNotExist(){
        Player Nikita = new Player(1, "Никита", 100);
        Player Andrey = new Player(2, "Андрей", 120);
        Game game = new Game();

        game.register(Nikita);
        game.register(Andrey);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Андрей", "Рома")
        );

    }
    @Test
    public void testWhenAllPlayerNotExist(){
        Player Nikita = new Player(1, "Никита", 100);
        Player Andrey = new Player(2, "Андрей", 120);
        Game game = new Game();

        game.register(Nikita);
        game.register(Andrey);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Рома", "Максим")
        );

    }
}