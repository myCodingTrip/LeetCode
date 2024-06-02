//package contest.wc393.p3;
//
//import java.util.*;
//
//class Solution {
//    public long findKthSmallest(int[] coins, int k) {
//        Arrays.sort(coins);
//        int length = coins.length;
//        int max = coins[length - 1];
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            int x = 1;
//            while (x * coins[i] <= max) {
//                set.add(x * coins[i]);
//                x++;
//            }
//        }
//        List<Integer> list = new ArrayList<>(set);
//        Collections.sort(list);
//        int size=list.size();
//
//    }
//}
