package problem149;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class OfficialSolution {

    private int[][] points;
    //点数量
    private int n;
    private Map<Double, Integer> lines = new HashMap<>();
    //水平线数量
    private int horizontalLines;

    public int maxPoints(int[][] points) {

        this.points = points;
        // If the number of points is less than 3
        // they are all on the same line.
        n = points.length;
        if (n < 3)
            return n;

        int maxCount = 1;
        // Compute in a loop a max number of points
        // on a line containing point i.
        for (int i = 0; i < n - 1; i++)
            maxCount = Math.max(maxPoints(i), maxCount);

        return maxCount;
    }

    /*
    Compute the max number of points
    for a line containing point i.
    */
    private int maxPoints(int i) {
        // init lines passing through point i
        lines.clear();
        horizontalLines = 1;
        // One starts with just one point on a line : point i.
        int count = 1;
        // There is no duplicates of a point i so far.
        int duplicates = 0;

        // Compute lines passing through point i (fixed)
        // and point j (interation).
        // Update in a loop the number of points on a line
        // and the number of duplicates of point i.
        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = addLine(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }

    /**
     * Add a line passing through i and j points.
     * Update max number of points on a line containing point i.
     * Update a number of duplicates of i point.
     * <p>
     * 增加一条线穿越i j两点
     * 更新经过i点的一条线的最多点
     * 更新i点重复的点
     *
     * @param i
     * @param j
     * @param count
     * @param duplicates
     * @return
     */
    private Pair<Integer, Integer> addLine(int i, int j, int count, int duplicates) {
        // rewrite points as coordinates
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        // add a duplicate point
        if ((x1 == x2) && (y1 == y2))
            duplicates++;
            // add a horisontal line : y = const
        else if (y1 == y2) {
            horizontalLines += 1;
            count = Math.max(horizontalLines, count);
        }
        // add a line : x = slope * y + c
        // only slope is needed for a hash-map
        // since we always start from the same point
        else {
            double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(lines.get(slope), count);
        }
        return new Pair(count, duplicates);
    }

}
