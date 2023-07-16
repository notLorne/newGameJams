package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import objects.GameObject;
import gfx.ColorTable;

public class TextBox extends GameObject {
    private String text;
    private int textSize;
    private String[] charGrids;
    private Color backgroundColor;
    private Color textColor;

    public TextBox(int xPos, int yPos, String text, int textSize, int backgroundColorIndex, int textColorIndex) {
        super(xPos, yPos, 100, "UI"); // Set layer to "UI"
        this.text = text;
        this.textSize = textSize;
        this.backgroundColor = ColorTable.getPaletteColor(backgroundColorIndex, 1);
        this.textColor = ColorTable.getPaletteColor(textColorIndex, 1);
        this.charGrids = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            String charString = String.valueOf(character);
            this.charGrids[i] = CharTable.getCharString(charString);
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        // Draw background
        int paddingX = 4* (textSize / 2); // Adjust the padding
        int paddingY = 4* (textSize / 2); // Adjust the padding
        int boxWidth = (text.length() * textSize * 6) + (paddingX * 2);
        int boxHeight = (textSize * 7) + (paddingY * 2);
        g2d.setColor(backgroundColor);
        g2d.fillRect(getXPos(), getYPos(), boxWidth, boxHeight);

        // Draw text
        g2d.setColor(textColor);
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            String gridString = charGrids[i];
            for (int row = 0; row < 7; row++) {
                for (int col = 0; col < 5; col++) {
                    int index = (row * 5) + col;
                    if (gridString.charAt(index) == '1') {
                        int charPosX = getXPos() + paddingX + (i * textSize * 6) + (col * textSize);
                        int charPosY = getYPos() + paddingY + (row * textSize);
                        g2d.fillRect(charPosX, charPosY, textSize, textSize);
                    }
                }
            }
        }
    }
}
