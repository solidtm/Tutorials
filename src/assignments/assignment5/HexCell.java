package assignments.assignment5;

public class HexCell {
    private final int row, col;
    private boolean[] walls;
    private boolean visited;

    public HexCell(int row, int col) {
        this.row = row;
        this.col = col;
        this.walls = new boolean[]{true, true, true, true, true, true}; // All walls initially present
        this.visited = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean hasWall(int direction) {
        return walls[direction];
    }

    public void removeWall(int direction) {
        walls[direction] = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

