package grid;

/**
 * An Immutable Data Object class for representing a grid using a multi dimensional character array.
 */
public class Grid {
    private char[][] grid;

    public Grid(String[] grid){
        this.grid = new char[grid.length][];
        for(int i = 0; i < grid.length; i++){
            this.grid[i] = grid[i].toCharArray();
        }
    }

    public char get(Point point) { return grid[point.y][point.x]; }

    public int numberOfColumns(){
        return grid.length;
    }

    public int numberOfRows(){
        return grid[0].length;
    }
}
