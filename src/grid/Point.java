package grid;

/**
 * An Immutable Data Object class for containing a single coordinate
 */
public class Point implements Comparable<Point> {
    public static final char EMPTY = '-';

    public final int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x + 1, this.y + 1); //Increment zero based index when printing
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x < o.x){
            return -1;
        }
        else if(this.x > o.x){
            return 1;
        }
        else {
            if(this.y < o.y){
                return -1;
            }
            else if(this.y > o.y){
                return 1;
            }
            else{
                return 1;
            }
        }
    }
}
