package grid;

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

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public int width(){
        return end.x - start.x;
    }

    public int height(){
        return end.y - start.y;
    }

    public int area(){
        return width() * height();
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
