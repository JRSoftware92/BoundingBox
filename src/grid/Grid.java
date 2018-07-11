package grid;

public class Grid {
    private char[][] grid;

    public Grid(int numRows, int numColumns){
        grid = new char[numColumns][];
        for(int i = 0; i < numColumns; i++){
            grid[i] = new char[numRows];
        }
    }

    public Grid(char[][] grid){
        this.grid = grid;
    }

    public char get(Point point) { return grid[point.y][point.x]; }

    public char get(int x, int y){
        return grid[y][x];
    }

    public void set(Point point, char c) { grid[point.y][point.x] = c; }

    public void set(int x, int y, char c){
        grid[y][x] = c;
    }

    public int numberOfColumns(){
        return grid.length;
    }

    public int numberOfRows(){
        return grid[0].length;
    }
}
