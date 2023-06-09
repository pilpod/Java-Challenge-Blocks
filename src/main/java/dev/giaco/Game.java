package dev.giaco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import dev.giaco.entities.AbstractBlock;
import dev.giaco.entities.AbstractFactory;
import dev.giaco.entities.AttributeHandler;

public class Game {

    private String input;
    private AbstractFactory factory;

    public Game() {
    }

    public Game(AbstractFactory factory) {
        this.factory = factory;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Boolean overlaps() {

        Collection<AbstractBlock> blocksCollection = retrieveBlocksWithData();

        List<AbstractBlock> blocks = new ArrayList<>(blocksCollection);

        List<String> vectorsBlockOne = blocks.get(0).getOtherPos();
        List<String> vectorsBlockTwo = blocks.get(1).getOtherPos();

        Boolean overlaps = vectorsBlockOne.stream().anyMatch( (vector) -> vectorsBlockTwo.contains(vector));

        return overlaps;
    }

    public Collection<AbstractBlock> retrieveBlocksWithData() {

        String[] datas = input.split(" ");
        int attributesPerBlock = 5;
        int blocksQuantity = datas.length / attributesPerBlock;
        int start = 0;

        String[] dataBlock1 = Arrays.copyOfRange(datas, start, attributesPerBlock);
        String[] dataBlock2 = Arrays.copyOfRange(datas, attributesPerBlock++, datas.length);

        Collection<AbstractBlock> blocks = new ArrayList<AbstractBlock>();

        for (int i = 0; i < blocksQuantity; i++) {
            String[] data = (i < 1) ? dataBlock1 : dataBlock2 ;
            AttributeHandler handler = new AttributeHandler(data);
            blocks.add(factory.createBlock(handler.getId(), handler.getOrientation(), handler.getPosX(),
                    handler.getPosY(), handler.getLength()));
        }

        return blocks;
    }

}
