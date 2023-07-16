package gfx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.GameObject;

public class Renderer {
    private Map<String, List<GameObject>> layers;

    public Renderer() {
        layers = new HashMap<>();
        layers.put("background", new ArrayList<>());
        layers.put("floor", new ArrayList<>());
        layers.put("center", new ArrayList<>());
        layers.put("top", new ArrayList<>());
        layers.put("UI", new ArrayList<>());
    }

    public void addGameObject(GameObject gameObject) {
        String layer = gameObject.getLayer();
        layers.get(layer).add(gameObject);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        for (String layer : layers.keySet()) {
            List<GameObject> layerGameObjects = layers.get(layer);
            layerGameObjects.sort(Comparator.comparingInt(GameObject::getZOrder));
            for (GameObject gameObject : layerGameObjects) {
                gameObject.render(g2d);
            }
        }
    }
}
