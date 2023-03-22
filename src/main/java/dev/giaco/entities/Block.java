package dev.giaco.entities;

public class Block {

    private int id;
    private String orientation;
    private int positionX;
    private int positionY;
    private int blockLength;
    private int blockWidth = 1;

    public Block(int id, String orientation, int positionX, int positionY, int blockLength) {
        this.id = id;
        this.orientation = orientation;
        this.positionX = positionX;
        this.positionY = positionY;
        this.blockLength = blockLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getBlockLength() {
        return blockLength;
    }

    public void setBlockLength(int blockLength) {
        this.blockLength = blockLength;
    }

    public int getBlockWidth() {
        return blockWidth;
    }

}
