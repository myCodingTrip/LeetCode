package contest.wc400.p2;

import java.util.*;

class Solution {
    public int countDaysTimeout(int days, int[][] meetings) {
        boolean[] daysArr = new boolean[days + 1];
        for (int[] meeting : meetings) {
            for (int i = meeting[0]; i <= meeting[1]; i++) {
                daysArr[i] = true;
            }
        }
        int res = 0;
        for (boolean day : daysArr) {
            if (!day) {
                res++;
            }
        }
        return res - 1;
    }

    public int countDaysOOM(int days, int[][] meetings) {
        byte[] cal = new byte[days + 2];
        for (int[] meeting : meetings) {
            cal[meeting[0]]++;
            cal[meeting[1] + 1]--;
        }
        int res = 0;
        int temp = 0;
        for (int i = 1; i <= days; i++) {
            temp += cal[i];
            if (temp == 0) {
                res++;
            }
        }
        return res;
    }

    public int countDaysTimeout2(int days, int[][] meetings) {
        Set<Integer> set = new HashSet<>();
        for (int[] meeting : meetings) {
            for (int i = meeting[0]; i <= meeting[1]; i++) {
                set.add(i);
            }
        }
        int res = 0;
        for (int i = 1; i <= days; i++) {
            if (!set.contains(i)) {
                res++;
            }
        }
        return res;
    }

    public int countDays(int days, int[][] meetings) {
        int[][] merge = merge(meetings);
        for (int[] range : merge) {
            days -= range[1] - range[0] + 1;
        }
        return days;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int s = intervals[0][0];
        int e = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= e) {
                e = Math.max(e, intervals[i][1]);
            } else {
                list.add(new int[]{s, e});
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }
        list.add(new int[]{s, e});
        return list.toArray(new int[list.size()][2]);
    }
}
