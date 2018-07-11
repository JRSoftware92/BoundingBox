
public class BoundingBox {
    private Point start, end;

    public BoundingBox(Point start, Point end){
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", start.toString(), end.toString());
    }
}
