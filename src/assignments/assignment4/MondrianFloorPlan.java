package assignments.assignment4;


import java.awt.Color;
import BasicIO.*;
import Media.*;

public class MondrianFloorPlan {

    public static void main(String[] args) {
        BasicForm form = new BasicForm();
        TurtleDisplayer display;
        Turtle turtle = new Turtle(Turtle.FAST, Color.BLACK);

        form.addLabel("Enter floor dimensions and granularity:");
        form.addTextField("Width", "Width of the floor:");
        form.addTextField("Height", "Height of the floor:");
        form.addTextField("CellSize", "Size of each cell in pixels:");
        form.addTextField("Cutoff", "Minimum room size:");
        form.addTextField("Proclivity", "Probability (0-1) to stop early:");

        form.accept("Generate Floor Plan");

        int width = form.readInt("Width");
        int height = form.readInt("Height");
        int cellSize = form.readInt("CellSize");
        int cutoff = form.readInt("Cutoff");
        double proclivity = form.readDouble("Proclivity");

        if (width <= 0 || height <= 0 || cellSize <= 0 || cutoff <= 0 || proclivity < 0 || proclivity > 1) {
            System.out.println("Invalid input values. Please ensure all values are positive and within valid ranges.");
            return;
        }

        try {
            display = new TurtleDisplayer(turtle, width * cellSize, height * cellSize);
        } catch (Exception e) {
            System.out.println("Error initializing TurtleDisplayer: " + e.getMessage());
            return;
        }

        display.placeTurtle(turtle);

        FloorPlan floorPlan = new FloorPlan(width, height, cellSize, turtle, cutoff, proclivity);

        try {
            floorPlan.divide(0, 0, width, height);
        } catch (Exception e) {
            System.out.println("Error during floor division: " + e.getMessage());
        }

        display.close();
    }
}

class FloorPlan {
    private final int width;
    private final int height;
    private final int cellSize;
    private final Turtle turtle;
    private final int cutoff;
    private final double proclivity;

    public FloorPlan(int width, int height, int cellSize, Turtle turtle, int cutoff, double proclivity) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        this.turtle = turtle;
        this.cutoff = cutoff;
        this.proclivity = proclivity;
    }

    public void divide(int startX, int startY, int endX, int endY) {
        int roomWidth = endX - startX;
        int roomHeight = endY - startY;

        if (roomWidth < 2 || roomHeight < 2 || roomWidth <= cutoff || roomHeight <= cutoff || Math.random() < proclivity) {
            fillRoom(startX, startY, endX, endY);
            return;
        }

        if (roomWidth >= roomHeight) {
            int splitX = startX + (int) (Math.random() * (roomWidth - 2)) + 1;
            int doorY = startY + (int) (Math.random() * roomHeight);

            drawVerticalWall(splitX, startY, endY, doorY);

            divide(startX, startY, splitX, endY);
            divide(splitX, startY, endX, endY);
        } else {
            int splitY = startY + (int) (Math.random() * (roomHeight - 2)) + 1;
            int doorX = startX + (int) (Math.random() * roomWidth);

            drawHorizontalWall(startX, splitY, endX, doorX);

            divide(startX, startY, endX, splitY);
            divide(startX, splitY, endX, endY);
        }
    }

    private void drawVerticalWall(int x, int startY, int endY, int doorY) {
        turtle.penUp();
        turtle.moveTo(x * cellSize, startY * cellSize);

        for (int y = startY; y < endY; y++) {
            if (y == doorY) {
                turtle.penUp();
            } else {
                turtle.penDown();
            }
            turtle.moveTo(x * cellSize, (y + 1) * cellSize);
        }

        turtle.penUp();
    }

    private void drawHorizontalWall(int startX, int y, int endX, int doorX) {
        turtle.penUp();
        turtle.moveTo(startX * cellSize, y * cellSize);

        for (int x = startX; x < endX; x++) {
            if (x == doorX) {
                turtle.penUp();
            } else {
                turtle.penDown();
            }
            turtle.moveTo((x + 1) * cellSize, y * cellSize);
        }

        turtle.penUp();
    }

    private void fillRoom(int startX, int startY, int endX, int endY) {
        Color randomColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        turtle.setPenColor(randomColor);

        turtle.penUp();
        turtle.moveTo(startX * cellSize, startY * cellSize);
        turtle.penDown();

        for (int y = startY; y < endY; y++) {
            if (y % 2 == 0) {
                turtle.moveTo(endX * cellSize, y * cellSize);
            } else {
                turtle.moveTo(startX * cellSize, y * cellSize);
            }

            if (y + 1 < endY) {
                turtle.moveTo(turtle.getScreenX(), (y + 1) * cellSize);
            }
        }

        turtle.penUp();
    }
}