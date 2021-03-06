import grid.BoundingBox;
import grid.BoundingBoxUtil;
import grid.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculateBoundingBox {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        if(!in.hasNextLine()){
            System.out.println("No input grid was provided at runtime. Please specify an input grid whose bounding box"
                    + " should be calculated.");
            return;
        }

        List<String> lines = new ArrayList<>();
        while(in.hasNextLine()){
            lines.add(in.nextLine());
        }

        String[] lineArr = lines.toArray(new String[lines.size()]);

        Grid grid = new Grid(lineArr);

        BoundingBox boundingBox = BoundingBoxUtil.calculateLargestMinimumBoundingBox(grid);
        if (boundingBox != null) {
            System.out.println(boundingBox);
        }
        else {
            System.out.println("No Valid Bounding Box detected for the provided input.");
        }

        in.close();
    }
}
