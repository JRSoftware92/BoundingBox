package grid;

// Can be solved using DFS/BFS
// Set visitor on arbitrary points, have them traverse the full box. Once one finishes, set a new one down
// If this nth visitor visits a point already visited by a previous visitor - kill the visitor

public class BoundingBoxUtil {
    public static BoundingBox calculateBoundingBox(Grid grid){
        int numRows = grid.numberOfRows();
        int numColumns = grid.numberOfColumns();

        for(int i = 0; i < numColumns; i++){
            for(int j = 0; j < numRows; j++){

            }
        }

        return null;
    }
}
