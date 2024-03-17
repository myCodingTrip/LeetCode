package problem.problem416;

//DFS方式解决
//无记忆化数组 超时
//有记忆化数组
class SolutionDFS {

    /**
     * mem[i][j] 为 0 1 2 分别代表 [0,i]区间的数据 未计算 可以 不可以 凑成j
     */
    private int[][] mem;

    public boolean canPartition(int[] nums) {

        //先算出目标：数组和的一半
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        int n = nums.length;
        mem = new int[n][sum];
        return dfs(n - 1, target, nums);
    }

    private boolean dfs(int i, int target, int[] nums) {
        if (i < 0 || target < 0) return false;
        if (target == 0) {
            mem[i][target] = 1;
            return true;
        }
        if (mem[i][target] == 1) {
            return true;
        } else if (mem[i][target] == 2) {
            return false;
        }
        //使用/不使用nums[i]
        boolean equal = dfs(i - 1, target, nums) || dfs(i - 1, target - nums[i], nums);
        if (equal) {
            mem[i][target] = 1;
        } else {
            mem[i][target] = 2;
        }
        return equal;
    }

    public static void main(String[] args) {
//        System.out.println(new SolutionDFS().canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
        System.out.println(new SolutionDFS().canPartition(new int[]{1, 1, 1, 1}));

    }
}
