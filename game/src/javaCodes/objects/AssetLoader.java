package objects;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AssetLoader {
    private static final String AUDIO_PATH = "src/assets/audio/";
    private static final String IMAGE_PATH = "src/assets/sprites/";

    private Map<String, Clip> audioAssets;
    private Map<String, BufferedImage> imageAssets;

    public AssetLoader() {
        audioAssets = new HashMap<>();
        imageAssets = new HashMap<>();
    }

    public void loadAllAssets() {
        loadAudioAssets();
        loadImageAssets();
    }

    private void loadAudioAssets() {
        // Load audio assets from the AUDIO_PATH
        // For each audio file, create a Clip and put it into the audioAssets map with a relevant name
        // Example:
        // audioAssets.put("backgroundMusic", loadAudioClip("background_music.wav"));
    }

    private void loadImageAssets() {
        // Load image assets from the IMAGE_PATH
        // For each image file, create a BufferedImage and put it into the imageAssets map with a relevant name
        // Example:
        // imageAssets.put("playerIdle", loadImage("player_idle.png"));
    }

    private Clip loadAudioClip(String fileName) {
        try {
            File file = new File(AUDIO_PATH + fileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(new File(IMAGE_PATH + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Clip getAudioAsset(String name) {
        return audioAssets.get(name);
    }

    public BufferedImage getImageAsset(String name) {
        return imageAssets.get(name);
    }
}
