package bfs;

import grid.Grid;
import grid.Point;

import java.util.*;

public class Visitor {
    private HashSet<Point> visitedPoints = new HashSet<>();

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
        return !hasVisited(point) && grid.get(point) != Point.EMPTY;
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

            if(canVisit(current)){
                visit(current);

                adjacentPoints = getAdjacentPoints(current);
                for(Point p : adjacentPoints){
                    if(!hasVisited(p)) {
                        queue.add(p);
                    }
                }
            }
        }
    }

    private List<Point> getAdjacentPoints(Point point){
        ArrayList<Point> output = new ArrayList<>();

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
