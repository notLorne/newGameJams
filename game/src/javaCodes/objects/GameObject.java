package objects;

import java.awt.Graphics2D;

public abstract class GameObject {
    private int zOrder;
    private int xPos;
    private int yPos;
    private String layer;

    public GameObject(int xPos, int yPos, int zOrder, String layer) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zOrder = zOrder;
        this.layer = layer;
    }

    public int getZOrder() {
        return zOrder;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public abstract void render(Graphics2D g2d);
}
