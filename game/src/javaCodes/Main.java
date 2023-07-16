import gfx.GameWindow;
import gfx.Renderer;
import objects.TextBox;


public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();

        // Retrieve the Renderer from the GameWindow
        Renderer renderer = gameWindow.getRenderer();

        // Create a TextBox and add it to the Renderer
        TextBox textBox = new TextBox(100, 100, "Hello bitches!", 4, 12, 22);
        renderer.addGameObject(textBox);

        // Start the game loop
        gameWindow.startGameLoop();
    }
}
