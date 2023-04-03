package dev.giaco.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlockTest {

    private Block block;
    private Block block2;

    @BeforeEach
    void setUp() {
        block = new Block(0, "h", 2, 3, 5);
        block2 = new Block(0, "v", 2, 3, 5);
    }

    @Test
    public void testBlockHaveIdOrientationPositionXPositionYAndLength() {
        assertThat(block.getId(), equalTo(0));
        assertThat(block.getOrientation(), equalTo("h"));
        assertThat(block.getPositionX(), equalTo(2));
        assertThat(block.getPositionY(), equalTo(3));
        assertThat(block.getBlockLength(), equalTo(5));
    }

    @Test
    public void testSetOtherPositionMethodBlockOrientacionH() {
        List<String> pos = block.getOtherPos();

        assertThat(pos.size(), equalTo(5));
        assertThat(pos.get(0), equalTo("2,3"));
        assertThat(pos.get(1), equalTo("3,3"));
        assertThat(pos.get(2), equalTo("4,3"));
        assertThat(pos.get(3), equalTo("5,3"));
        assertThat(pos.get(4), equalTo("6,3"));
    }

    @Test
    public void testSetOtherPositionMethodBlockOrientacionV() {
        List<String> pos = block2.getOtherPos();

        assertThat(pos.size(), equalTo(5));
        assertThat(pos.get(0), equalTo("2,3"));
        assertThat(pos.get(1), equalTo("2,4"));
        assertThat(pos.get(2), equalTo("2,5"));
        assertThat(pos.get(3), equalTo("2,6"));
        assertThat(pos.get(4), equalTo("2,7"));
    }

    

    

}
