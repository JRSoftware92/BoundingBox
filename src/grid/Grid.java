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

    public Grid subGrid(Point start, Point end){
        int numRows = numberOfRows();
        int numColumns = numberOfColumns();

        Grid output = new Grid(end.x - start.x, end.y - start.y);

        for(int i = start.y; i < end.y && i < numColumns; i++){
            for(int j = start.x; j < end.x && j < numRows; j++){
                output.set(j - start.x, i - start.y, this.get(j, i));
            }
        }

        return output;
    }
}
