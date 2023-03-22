package dev.giaco.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class AttributeHandlerTest {

    @Test
    void testSetAllAttributes() {
        String[] datas = {"0","h", "2", "3", "5"};
        AttributeHandler handler = new AttributeHandler(datas);
        
        assertThat(handler.getId(), equalTo(0));
        assertThat(handler.getOrientation(), equalTo("h"));
        assertThat(handler.getPosX(), equalTo(2));
        assertThat(handler.getPosY(), equalTo(3));
        assertThat(handler.getLength(), equalTo(5));
    }
}
