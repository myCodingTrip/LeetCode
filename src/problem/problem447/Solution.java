package problem.problem447;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            Map<Integer, Integer> distanceCountMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int x1 = points[j][0];
                    int y1 = points[j][1];
                    //注意整形越界问题
                    int distance = (int) (Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
                    distanceCountMap.put(distance, distanceCountMap.getOrDefault(distance, 0) + 1);
                }
            }
            for (Integer distance : distanceCountMap.keySet()) {
                Integer count = distanceCountMap.get(distance);
                if (count >= 2) {
                    res += count * (count - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 0}, {2, 0}};
        Solution sol = new Solution();
        System.out.println(sol.numberOfBoomerangs(a));
    }
}
