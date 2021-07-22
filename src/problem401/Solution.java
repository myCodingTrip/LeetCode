package problem401;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> res = new ArrayList<>();
    private int gNum;

    public List<String> readBinaryWatch(int num) {
        boolean[] watch = new boolean[10];
        gNum = num;
        dfs(0, watch, 0);
        return res;
    }

    private void dfs(int start, boolean[] watch, int count) {
        if (count == gNum) {
            int hour = 0;
            int min = 0;
            for (int i = 0; i < watch.length; i++) {
                if (i < 4) {
                    hour += (watch[i] ? 1 : 0) * Math.pow(2, 3 - i);
                } else {
                    min += (watch[i] ? 1 : 0) * Math.pow(2, 9 - i);
                }
            }
            if (hour >= 12 || min >= 60) {
                return;
            }
            res.add(hour + ":" + format(min));
            return;
        }
        if (start == watch.length) return;
        dfs(start + 1, watch, count);
        watch[start] = true;
        dfs(start + 1, watch, count + 1);
        watch[start] = false;
    }

    private String format(int num) {
        if (num < 10) {
            return "0" + num;
        } else {
            return "" + num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(3));
    }
}