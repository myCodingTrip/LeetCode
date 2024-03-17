package problem.problem27;


class Solution {

    //两个反向的指针
    public int removeElementMy(int[] nums, int val) {
        //结果数组[0,end]
        int start = 0, end = nums.length - 1;
        //空数组
        if (start > end) return 0;
        while (start < end) {
            // 找到第一个无效的数字
            if (nums[start] == val) {
                //找到末端第一个不是val的数
                while (nums[end] == val) {
                    end--;
                    if (end < 0) return 0;
                }
                //把末端的有效数字放到前面 后边界前移
                if (start < end) {
                    nums[start] = nums[end];
                    end--;
                }
            }
            start++;
        }
        while (nums[end] == val) {
            end--;
            if (end < 0) return 0;
        }
        //end为从0开始的下标
        return end + 1;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums;
        int c;

        nums = new int[]{3, 2, 2, 3};
        c = sol.removeElement(nums, 3);
        print(nums, c);

        nums = new int[]{};
        c = sol.removeElement(nums, 3);
        print(nums, c);

        nums = new int[]{2, 3, 3};
        c = sol.removeElement(nums, 3);
        print(nums, c);

        nums = new int[]{3, 3};
        c = sol.removeElement(nums, 3);
        print(nums, c);

//        System.out.println(Arrays.toString(nums));
    }

    private static void print(int[] num, int c) {
        for (int i = 0; i < c; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
