package dev.giaco.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBlock {
    
    private int id;
    private String orientation;
    private int positionX;
    private int positionY;
    private int blockLength;
    private int blockWidth = 1;
    private List<String> otherPos = new ArrayList<>();

    public AbstractBlock(int id, String orientation, int positionX, int positionY, int blockLength) {
        this.id = id;
        this.orientation = orientation;
        this.positionX = positionX;
        this.positionY = positionY;
        this.blockLength = blockLength;

        setOtherPos();
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

    public List<String> getOtherPos() {
        return otherPos;
    }

    public void setOtherPos() {
        if (getOrientation() == "h") {
            for (int i = 0; i < getBlockLength(); i++) {
                otherPos.add(getPositionX() +","+ (getPositionY() + i));
            }
        }

        if (getOrientation() == "v") {
            for (int i = 0; i < getBlockLength(); i++) {
                otherPos.add((getPositionX() + i)+","+getPositionY());
            }
        }
    }



}
