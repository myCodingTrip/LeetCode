package problem347;

import java.util.*;

/**
 * 通过优先队列进行解决
 * 维护一个size=k的PriorityQueue，最后取出队列中的元素并翻转
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<Tuple> queue = new PriorityQueue<>(k);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        for (Integer i : countMap.keySet()) {
            Integer count = countMap.get(i);
            if (queue.size() < k) {
                queue.offer(new Tuple(i, count));
            } else if (queue.size() == k && count > queue.peek().count) {
                queue.poll();
                queue.offer(new Tuple(i, count));
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().num);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 保存数字及出现的次数
     */
    class Tuple implements Comparable<Tuple> {
        int num;
        int count;

        public Tuple(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }
}