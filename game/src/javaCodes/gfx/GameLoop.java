package gfx;

import java.awt.Graphics;

public class GameLoop implements Runnable {
    private static final int TARGET_FPS = 30;
    private static final long TARGET_TIME = 1000000000 / TARGET_FPS;
    private static final int MAX_FPS = 60;

    private boolean running;
    private final Renderer renderer;
    private final GameWindow gameWindow;

    public GameLoop(Renderer renderer, GameWindow gameWindow) {
        this.running = false;
        this.renderer = renderer;
        this.gameWindow = gameWindow;
    }

    @Override
    public void run() {
        running = true;

        long lastTime = System.nanoTime();
        double delta = 0.0;
        double nsPerUpdate = 1000000000.0 / TARGET_FPS;

        int frames = 0;
        int updates = 0;

        while (running) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / nsPerUpdate;
            lastTime = currentTime;

            // Variable timestep with frame time interpolation
            while (delta >= 1.0) {
                update();
                updates++;
                delta--;
            }

            render();
            frames++;

            // Frame rate smoothing
            if (System.currentTimeMillis() - lastTime >= 1000) {
                int smoothedFPS = frames / (MAX_FPS / TARGET_FPS);
                System.out.println("Smoothed FPS: " + smoothedFPS + ", Updates: " + updates);
                frames = 0;
                updates = 0;
                lastTime += 1000;
            }

            // Cap the frame rate
            if (TARGET_FPS > MAX_FPS) {
                try {
                    Thread.sleep((long) ((1000.0 / MAX_FPS) - (currentTime - System.nanoTime()) / 1000000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start() {
        if (running) {
            return;
        }

        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }

    private void update() {
        // Your game logic update code goes here
    }

    private void render() {
        gameWindow.render();
    }
}
