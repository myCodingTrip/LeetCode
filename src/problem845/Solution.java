package problem845;

class Solution {
    enum Direction {
        UP, DOWN, NONE
    }

    public int longestMountain(int[] arr) {
        int length = arr.length;
        int res = 0;
        int mountainLen = 0;
        Direction status = Direction.NONE;
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] < arr[i]) {
                if (Direction.UP.equals(status)) {
                    mountainLen++;
                } else {
                    if (mountainLen > res) {
                        res = mountainLen;
                    }
                    mountainLen = 2;
                    status = Direction.UP;
                }
            } else if (arr[i - 1] > arr[i]) {
                if (!Direction.NONE.equals(status)) {
                    mountainLen++;
                    status = Direction.DOWN;
                }
            } else {
                status = Direction.NONE;
            }
        }
        if (Direction.DOWN.equals(status)) {
            if (mountainLen > res) {
                res = mountainLen;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
//        System.out.println(new Solution().longestMountain(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}));
//        System.out.println(new Solution().longestMountain(new int[]{2, 3}));
//        System.out.println(new Solution().longestMountain(new int[]{0, 2, 0, 2, 1, 2, 3, 4, 4, 1}));
        System.out.println(new Solution().longestMountain(new int[]{2, 0, 2, 2, 3}));
    }
}
