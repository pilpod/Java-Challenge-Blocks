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
        assertThat(blocks.get(1).getOrientation(), equalTo("v"));
    }

    @Test
    public void testGameBlocksOverlaps() {
        game.setInput("0 h 2 3 5 1 v 4 1 5");
        Boolean areOverlaps = game.check();
        assertThat(areOverlaps, is(true));
    }

}
