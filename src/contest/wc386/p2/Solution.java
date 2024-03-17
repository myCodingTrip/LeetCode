package contest.wc386.p2;

class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long res = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int overlapWidth = Math.max(0, Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]));
                int overlapHeight = Math.max(0, Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]));
                long area = (long) Math.min(overlapHeight, overlapWidth) * Math.min(overlapHeight, overlapWidth);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
