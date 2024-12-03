package assignments.assignment5;

import BasicIO.BasicForm;
import Media.Turtle;
import Media.TurtleDisplayer;

import java.awt.*;
import java.util.Random;

public class HexMazeApp {
    public static void main(String[] args) {
        BasicForm form = new BasicForm();
        Turtle turtle = new Turtle(Turtle.FAST, Color.BLACK);

        form.addLabel("Enter maze parameters:");
        form.addTextField("Rows", "Number of rows:");
        form.addTextField("Cols", "Number of columns:");

        form.accept("Generate Hex Maze");

        int rows = form.readInt("Rows");
        int cols = form.readInt("Cols");

        TurtleDisplayer display = new TurtleDisplayer(turtle, cols * 60, rows * 60);
        display.placeTurtle(turtle);

        Random random = new Random();
        HexMaze maze = new HexMaze(rows, cols, turtle);
        maze.generateMaze(random.nextInt(rows), random.nextInt(cols));
        maze.drawMaze();

        display.close();
    }
}

