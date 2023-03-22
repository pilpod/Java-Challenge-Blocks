package dev.giaco.entities;

import org.apache.commons.lang3.StringUtils;

public class AttributeHandler {

    private int id;
    private String orientation;
    private int posX;
    private int posY;
    private int length;

    private String[] dataInput;

    public AttributeHandler(String[] dataBlock1) {
        dataInput = dataBlock1;
        this.setAllAttributes();
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

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setAllAttributes() {

        for (int index = 0; index < dataInput.length; index++) {

            int number = 0;

            if (StringUtils.isNumeric(dataInput[index])) {
                number = Integer.parseInt(dataInput[index]);
            }

            if(index == 0) this.setId(number);
            if(index == 1) this.setOrientation(dataInput[index]);
            if(index == 2) this.setPosX(number);
            if(index == 3) this.setPosY(number);
            if(index == 4) this.setLength(number);
        }
    }

}
