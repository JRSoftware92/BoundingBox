package bfs;

import grid.Grid;
import grid.Point;

import java.util.*;

/**
 * A Grid Traversal class which uses BFS to traverse all non-empty, connected sections of a grid from a given point
 * Please note: This entity only checks for Empty Characters when determining if a tile is not traversable. Therefore
 * it will consider any character that is not a '-' character to be traversable, and will group all non '-' characters together.
 */
public class Visitor {
    private Set<Point> visitedPoints = new HashSet<>();

    private Grid grid;

    public Visitor(Point initial, Grid grid){
        this.grid = grid;

        explore(initial);
    }

    public List<Point> getVisitedPoints(){
        List<Point> sortedList = new ArrayList<>(visitedPoints);

        if(sortedList.size() < 2){
            return sortedList;
        }

        Collections.sort(sortedList);
        return sortedList;
    }

    private boolean hasVisited(Point point){
        return visitedPoints.contains(point);
    }

    private boolean canVisit(Point point){
        return grid.get(point) != Point.EMPTY;
    }

    private void visit(Point point){
        visitedPoints.add(point);
    }

    private void explore(Point start){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        List<Point> adjacentPoints;
        Point current;
        while(!queue.isEmpty()){
            current = queue.poll();

            // Check to make sure that the current point is not empty
            if(canVisit(current)){
                visit(current);

                adjacentPoints = getAdjacentPoints(current);
                for(Point p : adjacentPoints){
                    // Prevents Re-queueing of visited points
                    if(!hasVisited(p)) {
                        queue.add(p);
                    }
                }
            }
        }
    }

    private List<Point> getAdjacentPoints(Point point){
        List<Point> output = new ArrayList<>();

        int numRows = grid.numberOfRows();
        int numColumns = grid.numberOfColumns();

        if(point.x - 1 > -1){   // Left
            output.add(new Point(point.x - 1, point.y));
        }
        if(point.y - 1 > -1){   // Up
            output.add(new Point(point.x, point.y - 1));
        }

        if(point.x + 1 < numRows){  //Right
            output.add(new Point(point.x + 1, point.y));
        }
        if(point.y + 1 < numColumns){   //Down
            output.add(new Point(point.x, point.y + 1));
        }

        return output;
    }
}
