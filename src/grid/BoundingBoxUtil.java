package grid;

// Can be solved using DFS/BFS
// Set visitor on arbitrary points, have them traverse the full box. Once one finishes, set a new one down
// If this nth visitor visits a point already visited by a previous visitor - kill the visitor

import bfs.Visitor;

import java.util.*;

public class BoundingBoxUtil {

    public static BoundingBox calculateLargestMinimumBoundingBox(Grid grid){
        List<LinkedList<Point>> populatedAreas = getPopulatedAreas(grid);

        return getLargestMinimumBoundingBox(populatedAreas);
    }

    // Assumes the input list is not null and non-empty
    private static BoundingBox getLargestMinimumBoundingBox(List<LinkedList<Point>> populatedAreas){
        LinkedList<BoundingBox> boundingBoxes = new LinkedList<>();
        for(LinkedList<Point> points : populatedAreas){
            boundingBoxes.add(getBoundingBox(points));
        }

        Collections.sort(boundingBoxes);

        return boundingBoxes.getLast();
    }

    // Assumes the input list is not null, non-empty, and sorted in ascending order
    private static BoundingBox getBoundingBox(LinkedList<Point> sortedPoints){
        Point start = sortedPoints.getFirst();
        Point end = sortedPoints.getLast();

        return new BoundingBox(start, end);
    }

    // Assumes the grid is not null
    private static List<LinkedList<Point>> getPopulatedAreas(Grid grid){
        int numRows = grid.numberOfRows();
        int numColumns = grid.numberOfColumns();

        Visitor visitor;
        Point point;
        LinkedList<Point> visitedPoints;

        Set<Point> allVisitedPoints = new HashSet<>();
        List<LinkedList<Point>> output = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                point = new Point(i, j);
                if(!allVisitedPoints.contains(point)){
                    visitor = new Visitor(point, grid);

                    if(visitor.hasMoved()){
                        visitedPoints = visitor.getVisitedPoints();
                        allVisitedPoints.addAll(visitedPoints);
                        output.add(visitedPoints);
                    }
                }
            }
        }

        return output;
    }
}
