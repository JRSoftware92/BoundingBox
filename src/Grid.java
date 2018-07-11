
public class Grid {
    private char[][] grid;

    public Grid(char[][] grid){
        this.grid = grid;
    }

    public char get(int x, int y){
        return grid[y][x];
    }

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

        char[][] output = new char[end.y - start.y][];
        for(int i = start.y; i < end.y && i < numColumns; i++){
            output[i - start.y] = new char[end.x - start.x];
            for(int j = start.x; j < end.x && j < numRows; j++){
                output[i - start.y][j - start.x] = this.grid[i][j];
            }
        }

        return new Grid(output);
    }
}
