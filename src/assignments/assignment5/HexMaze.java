package assignments.assignment5;

import Media.Turtle;
import java.util.Random;

public class HexMaze {
    private int rows, cols;
    private HexCell[][] grid;
    private Turtle turtle;

    public HexMaze(int rows, int cols, Turtle turtle) {
        this.rows = rows;
        this.cols = cols;
        this.turtle = turtle;
        this.grid = new HexCell[rows][cols];

        // Initialize grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r % 2 == 0 && c % 2 == 0) || (r % 2 != 0 && c % 2 != 0)) {
                    grid[r][c] = new HexCell(r, c);
                }
            }
        }
    }

    public void generateMaze(int startRow, int startCol) {
        recursiveMaze(startRow, startCol);
    }

    private void recursiveMaze(int row, int col) {
        HexCell current = grid[row][col];
        if (current.isVisited()) return; // Stop if already visited - base case

        current.setVisited(true); // Mark as visited
        Random random = new Random();

        // Shuffle directions
        int[] directions = {0, 1, 2, 3, 4, 5};
        for (int i = directions.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = directions[i];
            directions[i] = directions[j];
            directions[j] = temp;
        }

        for (int direction : directions) {
            int newRow = row + getRowOffset(direction);
            int newCol = col + getColOffset(row, direction);

            if (isValidCell(newRow, newCol)) {
                HexCell neighbor = grid[newRow][newCol];

                if (neighbor != null && !neighbor.isVisited()) { // Process only unvisited cells
                    current.removeWall(direction);
                    neighbor.removeWall(getOppositeDirection(direction));

                    recursiveMaze(newRow, newCol);
                }
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] != null;
    }

    private int getRowOffset(int direction) {
        return switch (direction) {
            case 0, 3 -> 0; // North/South
            case 1, 2 -> -1; // NE/SE
            case 4, 5 -> 1; // SW/NW
            default -> 0;
        };
    }

    private int getColOffset(int row, int direction) {
        return switch (direction) {
            case 0, 3 -> 0; // North/South
            case 1, 5 -> row % 2 == 0 ? 1 : 0; // NE/NW
            case 2, 4 -> row % 2 == 0 ? 1 : -1; // SE/SW
            default -> 0;
        };
    }

    private int getOppositeDirection(int direction) {
        return (direction + 3) % 6;
    }

    public void drawMaze() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != null) {
                    drawHex(grid[r][c]);
                }
            }
        }
    }

    private void drawHex(HexCell cell) {
        int centerX = cell.getCol() * 50;
        int centerY = cell.getRow() * 50;
        double size = 25;

        double[][] vertices = new double[6][2];
        for (int i = 0; i < 6; i++) {
            double angleRad = Math.toRadians(60 * i);
            vertices[i][0] = centerX + size * Math.cos(angleRad);
            vertices[i][1] = centerY + size * Math.sin(angleRad);
        }

        for (int i = 0; i < 6; i++) {
            if (cell.hasWall(i)) { // Only draw if this wall is present
                int next = (i + 1) % 6;
                turtle.penUp();
                turtle.moveTo((int) vertices[i][0], (int) vertices[i][1]);
                turtle.penDown();
                turtle.moveTo((int) vertices[next][0], (int) vertices[next][1]);
            }
        }
        turtle.penUp();
    }
}

