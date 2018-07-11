package grid;

// Can be solved using DFS/BFS
// Set visitor on arbitrary points, have them traverse the full box. Once one finishes, set a new one down
// If this nth visitor visits a point already visited by a previous visitor - kill the visitor

import bfs.Visitor;

import java.util.*;

public class BoundingBoxUtil {

    public static BoundingBox calculateLargestMinimumBoundingBox(Grid grid){
        return getLargestMinimumBoundingBox(getPopulatedAreas(grid));
    }

    // Assumes the input list is not null and non-empty
    private static BoundingBox getLargestMinimumBoundingBox(List<List<Point>> populatedAreas){
        List<BoundingBox> boundingBoxes = new ArrayList<>();
        for(List<Point> points : populatedAreas){
            boundingBoxes.add(getBoundingBox(points));
        }

        List<BoundingBox> nonIntersectionBoxes = getNonIntersectingBoundingBoxes(boundingBoxes);

        // Sort Boxes and retrieve the last box (the one with the largest area)
        Collections.sort(nonIntersectionBoxes);
        return nonIntersectionBoxes.get(nonIntersectionBoxes.size() - 1);
    }

    // Assumes the input list is not null
    private static List<BoundingBox> getNonIntersectingBoundingBoxes(List<BoundingBox> boundingBoxes){
        List<BoundingBox> output = new ArrayList<>();
        int size = boundingBoxes.size();

        BoundingBox subject;
        boolean intersection;
        for(int i = 0; i < size; i++){
            subject = boundingBoxes.get(i);
            intersection = false;

            // Search for Intersections
            for(int j = 0; j < size; j++){
                if(i != j && subject.intersectsWith(boundingBoxes.get(j))){
                    intersection = true;
                    break;
                }
            }

            if(!intersection){
                output.add(subject);
            }
        }

        return output;
    }

    // Assumes the input list is not null, non-empty, and sorted in ascending order
    private static BoundingBox getBoundingBox(List<Point> sortedPoints){
        Point start = sortedPoints.get(0);                         // Minimum Point
        Point end = sortedPoints.get(sortedPoints.size() - 1);     // Maximum Point

        return new BoundingBox(start, end);
    }

    // Assumes the grid is not null
    private static List<List<Point>> getPopulatedAreas(Grid grid){
        int numRows = grid.numberOfRows();
        int numColumns = grid.numberOfColumns();

        Visitor visitor;
        Point point;
        List<Point> visitedPoints;

        Set<Point> allVisitedPoints = new HashSet<>();
        List<List<Point>> output = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                point = new Point(i, j);

                // Exclude Empty and Visited tiles
                if(grid.get(point) != Point.EMPTY && !allVisitedPoints.contains(point)){
                    visitor = new Visitor(point, grid);

                    // Visitor automatically starts moving after construction
                    visitedPoints = visitor.getVisitedPoints();

                    // Used to ensure future visitors do not waste time on explored subsections
                    allVisitedPoints.addAll(visitedPoints);

                    output.add(visitedPoints);
                }
            }
        }

        return output;
    }
}
