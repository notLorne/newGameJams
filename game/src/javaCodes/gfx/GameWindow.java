package gfx;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameWindow extends Canvas {
    private static final int WIDTH = 640;
    private static final int HEIGHT = 360;
    private final Renderer renderer;
    private final GameLoop gameLoop;
    private final BufferStrategy bufferStrategy;

    public GameWindow() {
        JFrame frame = new JFrame("Game Window");
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        createBufferStrategy(3); // Triple buffering
        bufferStrategy = getBufferStrategy();

        renderer = new Renderer();
        gameLoop = new GameLoop(renderer, this);
    }

    public void startGameLoop() {
        gameLoop.start();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    // Rendering using buffer strategy
    public void render() {
        // Get the graphics context from the buffer strategy
        Graphics bufferGraphics = bufferStrategy.getDrawGraphics();

        // Your rendering code goes here
        renderer.render(bufferGraphics);

        // Dispose of the graphics context and show the rendered buffer
        bufferGraphics.dispose();
        bufferStrategy.show();
    }

    // Optionally, you can override the update method to prevent default clearing of the screen
    @Override
    public void update(Graphics g) {
        // No need to call super.update(g)
        render();
    }
}
