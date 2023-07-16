package gfx;

import java.awt.Color;

public class ColorTable {
    private static final Color[] colors = {
        // All basic colors 0-46
        // Grey tones
        new Color(0, 0, 0), // Black 0
        new Color(64, 64, 64), // Charcoal 1
        new Color(128, 128, 128), // Grey 2
        new Color(192, 192, 192), // Smoke 3
        new Color(255, 255, 255), // White 4
        // Brown reds
        new Color(128, 0, 0), // Maroon 5
        new Color(165, 42, 42), // Brown 6
        new Color(220, 20, 60), // Crimson 7
        new Color(255, 0, 0), // Red 8
        new Color(240, 128, 128), // Light Coral 9 
        new Color(255, 160, 122), // Light Salmon 10
        // Orange Yellow
        new Color(255, 69, 0), // Orange Red 11
        new Color(255, 165, 0), // Orange 12
        new Color(255, 215, 0), // Gold 13
        new Color(218, 165, 32), // Golden Rod 14
        new Color(240, 230, 140), // Khaki 15
        new Color(255, 255, 0), // Yellow 16
        // Green 
        new Color(154, 205, 50), // Yellow Green 17
        new Color(128, 128, 0), // Olive 18
        new Color(107, 142, 35), // Olive Drab 19
        new Color(124, 252, 0), // Lawn Green 20
        new Color(0, 128, 0), // Green 21
        new Color(50, 205, 50), // Lime Green 22
        new Color(152, 251, 152), // Pale Green 23
        new Color(0, 255, 127), // Spring Green 24
        new Color(32, 178, 170), // Light Sea Green 25
        // Blue
        new Color(0, 128, 128), // Teal 26
        new Color(0, 255, 255), // Aqua 27
        new Color(72, 209, 204), // Medium Turquoise 28
        new Color(176, 224, 230), // Powder Blue 29
        new Color(95, 158, 160), // Cadet Blue 30 
        new Color(70, 130, 180), // Steel Blue 31
        new Color(100, 149, 237), // Cornflower Blue 32 
        new Color(30, 144, 255), // Dodger Blue 33
        new Color(135, 206, 250), // Light Sky Blue 34
        new Color(0, 0, 128), // Navy 35
        new Color(0, 0, 255), // Blue 36
        // Purple
        new Color(75, 0, 130), // Indigo 37
        new Color(106, 90, 205), // Slate Blue 38
        new Color(147, 112, 219), // Medium Purple 39
        new Color(139, 0, 139), // Dark Magenta 40
        new Color(153, 50, 204), // Dark Orchid 41
        new Color(128, 0, 128), // Purple 42
        new Color(221, 160, 221), // Plum 43
        // Pink
        new Color(255, 0, 255), // Magenta / Fuchsia 44
        new Color(255, 20, 147), // Deep Pink 45
        new Color(255, 192, 203) // Pink 46
    };
    
    public static Color getPaletteColor(int indexNumber, float alphaValue) {
        if (alphaValue < 0 || alphaValue > 1) {
            alphaValue = 1;
        }
        int red = colors[indexNumber].getRed();
        int green = colors[indexNumber].getGreen();
        int blue = colors[indexNumber].getBlue();
        int alpha = (int) (alphaValue * 255);
        return new Color(red, green, blue, alpha);
    }
}

