package problem279;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numSquares(int n) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(n, 0));
        //用于记录计算过的数
        boolean[] visited = new boolean[n + 1];
        //46-->96.20 比set快了很多
        visited[n] = true;
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            System.out.println(tuple);
            // 此处应该从1开始 边界不是n
            for (int i = 1; ; i++) {
                int num = tuple.num - i * i;
                if (num < 0) break;
                //结果判断写在这里 提高速度 8%-> 38%
                if (num == 0) return tuple.distance + 1;
                if (!visited[num]) {
                    queue.offer(new Tuple(num, tuple.distance + 1));
                    visited[num] = true;
                }
            }
        }
        throw new RuntimeException("无解！！！");
    }

    class Tuple {
        int num;
        int distance;

        public Tuple(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "num=" + num +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}