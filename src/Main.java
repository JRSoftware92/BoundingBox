import grid.*;

public class Main {
    public static void main(String[] args){
        // TODO

        Grid grid = initializeEmptyGrid(4, 4);

        grid.set(2, 2, Point.NONEMPTY);
        grid.set(2, 3, Point.NONEMPTY);
        grid.set(3, 2, Point.NONEMPTY);
        grid.set(3, 3, Point.NONEMPTY);

        BoundingBox box = BoundingBoxUtil.calculateBoundingBox(grid);

        System.out.println("Bounding Box: " + box.toString());
    }

    private static Grid initializeEmptyGrid(int numRows, int numColumns){
        Grid grid = new Grid(numRows, numColumns);

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                grid.set(i, j, Point.EMPTY);
            }
        }

        return grid;
    }
}
