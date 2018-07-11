package grid;

/**
 * An Immutable Data Object class for containing two coordinates which represent the bounding box of a sub grid.
 * Contains methods for determining width, height, and area, as well as intersections with other bounding boxes.
 */
public class BoundingBox implements Comparable<BoundingBox> {
    private Point start, end;

    public BoundingBox(Point topLeft, Point bottomRight){
        int minX = Math.min(topLeft.x, bottomRight.x);
        int maxX = Math.max(topLeft.x, bottomRight.x);

        int minY = Math.min(topLeft.y, bottomRight.y);
        int maxY = Math.max(topLeft.y, bottomRight.y);

        this.start = new Point(minX, minY);
        this.end = new Point(maxX, maxY);
    }

    @SuppressWarnings("unused")
    public Point getStart() {
        return start;
    }

    @SuppressWarnings("unused")
    public Point getEnd() {
        return end;
    }

    private int width(){
        return end.x - start.x;
    }

    private int height(){
        return end.y - start.y;
    }

    private int area(){
        return width() * height();
    }

    public boolean intersectsWith(BoundingBox other){
        return this.intersectsWithX(other) && this.intersectsWithY(other);
    }

    private boolean intersectsWithX(BoundingBox other){
        if(this.start.x <= other.start.x && other.start.x <= this.end.x){   //Other Min X in Range
            return true;
        }
        if(this.start.x <= other.end.x && other.end.x <= this.end.x){       //Other Max X in Range
            return true;
        }
        return false;
    }

    private boolean intersectsWithY(BoundingBox other){
        if(this.start.y <= other.start.y && other.start.y <= this.end.y){   //Other Min Y in Range
            return true;
        }
        if(this.start.y <= other.end.y && other.end.y <= this.end.y){       //Other Max Y in Range
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s%s", start.toString(), end.toString());
    }

    @Override
    public int compareTo(BoundingBox o) {
        int thisArea = this.area();
        int otherArea = o.area();

        if(thisArea < otherArea){
            return -1;
        }
        else if(thisArea > otherArea){
            return 1;
        }
        else{
            return 0;
        }
    }
}
