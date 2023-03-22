package dev.giaco.entities;

public class BlockFactory extends AbstractFactory {

    @Override
    public AbstractBlock createBlock(int id, String orientation, int posX, int posY, int bockLength) {
        return super.createBlock(id, orientation, posX, posY, bockLength);
    }

}
