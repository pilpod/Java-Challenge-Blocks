package dev.giaco.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlockTest {

    private Block block;

    @BeforeEach
    void setUp() {
        block = new Block(0, "h", 2, 3, 5);
    }

    @Test
    public void testBlockHaveIdOrientationPositionXPositionYAndLength() {
        assertThat(block.getId(), equalTo(0));
        assertThat(block.getOrientation(), equalTo("h"));
        assertThat(block.getPositionX(), equalTo(2));
        assertThat(block.getPositionY(), equalTo(3));
        assertThat(block.getBlockLength(), equalTo(5));
    }

    

    

}
