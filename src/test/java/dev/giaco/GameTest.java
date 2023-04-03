package dev.giaco;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dev.giaco.entities.AbstractBlock;
import dev.giaco.entities.AbstractFactory;
import dev.giaco.entities.Block;
import dev.giaco.entities.BlockFactory;

public class GameTest {

    private static Game game;
    private static AbstractFactory factory;

    @BeforeAll
    static void beforeClass() {
        factory = new BlockFactory();
        game = new Game(factory);
    }

    @Test
    public void testGameCanSetInputTypeString() {
        game.setInput("0 h 2 3 5 1 v 3 1 1");
        assertThat(game.getInput(), equalTo("0 h 2 3 5 1 v 3 1 1"));
    }

    @Test
    public void testRetreaveBlocksWithData() {
        
        game.setInput("0 h 2 3 5 1 v 4 1 5");
        Collection<AbstractBlock> blocksData = game.retrieveBlocksWithData();

        List<Block> blocks = new ArrayList<>();

        for (AbstractBlock block : blocksData) {
            Block newBlock = new Block(block.getId(), block.getOrientation(), block.getPositionX(), block.getPositionY(), block.getBlockLength());
            blocks.add(newBlock);
        }

        assertThat(blocksData.size(), equalTo(2));
        assertThat(blocks.get(0).getId(), equalTo(0));
        assertThat(blocks.get(0).getOrientation(), equalTo("h"));
        assertThat(blocks.get(0).getPositionX(), equalTo(2));
        assertThat(blocks.get(0).getPositionY(), equalTo(3));
        assertThat(blocks.get(0).getBlockLength(), equalTo(5));
        assertThat(blocks.get(1).getId(), equalTo(1));
        assertThat(blocks.get(1).getOrientation(), equalTo("v"));
        assertThat(blocks.get(1).getPositionX(), equalTo(4));
        assertThat(blocks.get(1).getPositionY(), equalTo(1));
        assertThat(blocks.get(1).getBlockLength(), equalTo(5));
    }

    @Test
    public void testGameBlocksOverlapsCase0() {
        game.setInput("0 h 2 3 5 1 v 4 1 5");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(true));
    }

    @Test
    public void testGameBlocksOverlapsCase1() {
        game.setInput("0 h 2 3 5 1 v 3 1 1");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(false));
    }

    @Test
    public void testGameBlocksOverlapsCase2() {
        game.setInput("0 h 2 3 1 1 h 2 3 1");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(true));
    }

    @Test
    public void testGameBlocksOverlapsCase3() {
        game.setInput("0 h 2 3 5 1 h 3 3 2");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(true));
    }

    @Test
    public void testGameBlocksOverlapsCase4() {
        game.setInput("0 h 2 3 5 1 h 4 1 2");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(false));
    }

    @Test
    public void testGameBlocksOverlapsCase5() {
        game.setInput("0 h 2 3 5 1 v 3 1 3");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(true));
    }

    @Test
    public void testGameBlocksOverlapsCase6() {
        game.setInput("0 h 8 7 2 1 v 10 7 6");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(false));
    }

    @Test
    public void testGameBlocksOverlapsCase7() {
        game.setInput("0 h 2 3 5 1 v 3 1 2");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(false));
    }

    @Test
    public void testGameBlocksOverlapsCase8() {
        game.setInput("0 h 4 3 3 2 v 6 2 2");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(true));
    }

    @Test
    public void testGameBlocksOverlapsCase9() {
        game.setInput("0 v 3 3 2 1 v 3 5 2");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(false));
    }

    @Test
    public void testGameBlocksOverlapsCase10() {
        game.setInput("0 h 1 3 2 1 h 5 3 2");
        Boolean areOverlaps = game.overlaps();
        assertThat(areOverlaps, is(false));
    }

}
