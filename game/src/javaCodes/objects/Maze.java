package objects;

import java.util.Arrays;

public class Maze {
    // Properties
    private int xSize;
    private int ySize;
    private int totalStep;
    private int[][] mazeGrid;

    // Constructor
    public Maze(int sizeX, int sizeY, int stepTotal) {
        this.xSize = sizeX;
        this.ySize = sizeY;
        this.totalStep = stepTotal;

        this.mazeGrid = createMaze();
    }

    // Methods
    private int[][] createMaze() {
        int[][] mazeGrid = new int[xSize][ySize];

        int nextDirection;
        int nextLength;

        int xStart = (int) (Math.random() * (xSize - 2)) + 2;
        int yStart = (int) (Math.random() * (ySize - 2)) + 2;

        int xCurrent = xStart;
        int yCurrent = yStart;

        int stepCounter = 0;

        int nextKey = totalStep / 4;
        int nextLock = 3 * nextKey;

        mazeGrid[xCurrent][yCurrent] = 2;

        while (stepCounter < totalStep) {
            int nextAxis = (int) (Math.random() * 2) + 1; // X-Axis = 1 | Y Axis = 2;

            if (nextAxis == 1) {
                if (xCurrent < 4) {
                    nextDirection = 1;
                } else if (xCurrent > xSize - 4) {
                    nextDirection = -1;
                } else {
                    nextDirection = (Math.random() * 100) < 50 ? 1 : -1;
                }

                nextLength = (int) (Math.random() * 24) + 12;

                for (int x = 0; x < nextLength; ++x) {
                    xCurrent += nextDirection;
                    nextDirection *= (xCurrent < 4 || xCurrent > xSize - 4) ? -1 : 1;

                    if (mazeGrid[xCurrent][yCurrent] == 0) {
                        mazeGrid[xCurrent][yCurrent] = 1;
                    }
                    if (stepCounter == nextKey) {
                        mazeGrid[xCurrent][yCurrent] = 4;
                    }
                    if (stepCounter == nextLock) {
                        mazeGrid[xCurrent][yCurrent] = 5;
                    }
                    stepCounter += 1;
                }
            }
            if (nextAxis == 2) {
                if (yCurrent < 4) {
                    nextDirection = 1;
                } else if (yCurrent > ySize - 4) {
                    nextDirection = -1;
                } else {
                    nextDirection = (Math.random() * 100) < 50 ? 1 : -1;
                }

                nextLength = (int) (Math.random() * 24) + 12;

                for (int y = 0; y < nextLength; ++y) {
                    yCurrent += nextDirection;
                    nextDirection *= (yCurrent < 4 || yCurrent > ySize - 4) ? -1 : 1;

                    if (mazeGrid[xCurrent][yCurrent] == 0) {
                        mazeGrid[xCurrent][yCurrent] = 1;
                    }
                    if (stepCounter == nextKey) {
                        mazeGrid[xCurrent][yCurrent] = 4;
                    }
                    if (stepCounter == nextLock) {
                        mazeGrid[xCurrent][yCurrent] = 5;
                    }
                    stepCounter += 1;
                }
            }
        }

        mazeGrid[xCurrent][yCurrent] = 3;
        return mazeGrid;
    }

    public int[][] getMazeGrid() {
        return mazeGrid;
    }
}
