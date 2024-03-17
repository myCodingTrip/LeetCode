package problem.problem435;

import java.util.Arrays;

//贪心算法 O(n)
class SolutionGreed {
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int res = 1;

        int pre = 0;
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {
                res++;
                pre = i;
            }
        }
        return length - res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionGreed().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
