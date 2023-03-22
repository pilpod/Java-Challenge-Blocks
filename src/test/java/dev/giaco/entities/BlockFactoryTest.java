package dev.giaco.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BlockFactoryTest {

    private static BlockFactory factory;

    @BeforeAll
    static void beforeClass() {
        factory = new BlockFactory();
    }

    @Test
    void testFactoryCanCreateBlock() {
        AbstractBlock block = factory.createBlock(0, "h", 2, 3, 5);
        assertThat(block, instanceOf(Block.class));
        assertThat(block.getId(), equalTo(0));
        assertThat(block.getOrientation(), equalTo("h"));
        assertThat(block.getPositionX(), equalTo(2));
        assertThat(block.getPositionY(), equalTo(3));
        assertThat(block.getBlockLength(), equalTo(5));
    }
}
