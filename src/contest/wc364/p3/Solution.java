package contest.wc364.p3;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    //单调栈
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int size = maxHeights.size();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        long[] arr = new long[size + 1];
        long sum = 0;
        for (int i = 0; i < size; i++) {
            Integer maxHeight = maxHeights.get(i);
            while (stack.size() > 1 && maxHeight < maxHeights.get(stack.peek())) {
                Integer end = stack.pop();
                Integer start = stack.peek();
                sum -= (long) maxHeights.get(end) * (end - start);
            }
            Integer j = stack.peek();
            sum += (long) maxHeights.get(i) * (i - j);
            stack.push(i);
            arr[i + 1] = sum;
        }
        //System.out.println(Arrays.toString(arr));

        long res = arr[size];
        stack.clear();
        stack.push(size);
        sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            Integer maxHeight = maxHeights.get(i);
            while (stack.size() > 1 && maxHeight < maxHeights.get(stack.peek())) {
                Integer start = stack.pop();
                Integer end = stack.peek();
                sum -= (long) maxHeights.get(start) * (end - start);
            }
            Integer j = stack.peek();
            sum += (long) maxHeights.get(i) * (j - i);
            stack.push(i);
            res = Math.max(res, sum + arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(1000000000, 1000000000, 1000000000)));
    }
}
