package problem509;

class Solution {
    //10ms
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    //记忆化搜索 0ms
    public int fib2(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int[] fibCache = new int[N + 1];
        fibCache[0] = 0;
        fibCache[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibCache[i] = -1;
        }
        return dfs(N, fibCache);
    }

    public int dfs(int N, int[] fibCache) {
        if (fibCache[N] != -1)
            return fibCache[N];
        else {
            int fibN = dfs(N - 1, fibCache) + dfs(N - 2, fibCache);
            fibCache[N] = fibN;
            return fibN;
        }
    }

    //动态规划 o（n）
    public int fib3(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int[] fibCache = new int[N + 1];
        fibCache[0] = 0;
        fibCache[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibCache[i] = fibCache[i - 1] + fibCache[i - 2];
        }
        return fibCache[N];
    }

    public static void main(String[] args) {

        int N = 45;

//        long start = System.currentTimeMillis();
//        System.out.println(new Solution().fib(N));
//        System.out.println(System.currentTimeMillis() - start);
//
//        start = System.currentTimeMillis();
//        System.out.println(new Solution().fib2(N));
//        System.out.println(System.currentTimeMillis() - start);

        System.out.println(new Solution().fib3(N));
    }
}