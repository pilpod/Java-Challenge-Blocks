package dev.giaco;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameTest {

    private static Game game;

    @BeforeAll
    static void beforeClass() {
        game = new Game();
    }

    @Test
    public void testGameReceiveInputTypeString() {
        game.setInput("0 h 2 3 5 1 v 3 1 1");
        assertThat(game.getInput(), equalTo("0 h 2 3 5 1 v 3 1 1"));
    }

    @Test
    public void testGameBlocksOverlaps() {
        game.setInput("0 h 2 3 5 1 v 4 1 5");
        Boolean areOverlaps = game.check();
        assertThat(areOverlaps, is(true));
    }

}
