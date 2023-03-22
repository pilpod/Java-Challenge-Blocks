package dev.giaco.entities;

public abstract class AbstractFactory {
    
    public AbstractBlock createBlock(int id, String orientation, int posX, int posY, int blockLength) {
        return new Block(id, orientation, posX, posY, blockLength);
    }

}
