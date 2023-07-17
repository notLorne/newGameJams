package objects;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {
    private static final String IMAGE_PATH = "game/src/assets/sprites";
    private static final String SEPARATOR = "_";
    private static final String EXTENSION = ".png";

    private final Map<String, BufferedImage[]> animations;

    public ImageLoader() {
        animations = new HashMap<>();
        loadAnimations();
    }

    private void loadAnimations() {
        File folder = new File(IMAGE_PATH);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(EXTENSION)) {
                    String filename = file.getName();
                    String nameWithoutExtension = filename.substring(0, filename.length() - EXTENSION.length());
                    String[] parts = nameWithoutExtension.split(SEPARATOR);

                    if (parts.length > 1) {
                        String animationName = parts[0];

                        try {
                            BufferedImage image = ImageIO.read(file);
                            animations.computeIfAbsent(animationName, k -> new BufferedImage[8]);
                            int frameIndex = Integer.parseInt(parts[1]);
                            animations.get(animationName)[frameIndex - 1] = image;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public BufferedImage[] getAnimations(String animationName) {
        return animations.getOrDefault(animationName, new BufferedImage[8]);
    }

    public static void main(String[] args) {
        ImageLoader imageLoader = new ImageLoader();
        BufferedImage[] playerRunningBackAnimation = imageLoader.getAnimations("playerRunningBack");

        // Now you can use the playerRunningBackAnimation array to play the animation in your game.
        // For example, you can iterate through the frames and display them at the appropriate rate.
    }
}
