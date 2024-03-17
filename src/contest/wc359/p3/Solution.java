package contest.wc359.p3;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    //超时
    public int maximizeTheProfit0(int n, List<List<Integer>> offers) {
        int[] arr = new int[n];
        offers.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });
        for (List<Integer> offer : offers) {
            Integer start = offer.get(0);
            Integer end = offer.get(1);
            Integer gold = offer.get(2);
            int value = start > 0 ? arr[start - 1] : 0;
            arr[end] = Math.max(arr[end], value + gold);
            for (int i = end + 1; i < n; i++) {
                arr[i] = Math.max(arr[end], arr[i]);
            }
            //System.out.println(Arrays.toString(arr));
        }
        return arr[n - 1];
    }

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] arr = new int[n];
        Map<Integer, List<List<Integer>>> endMap = offers.stream().collect(Collectors.groupingBy(list -> list.get(1)));
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                arr[i] = arr[i - 1];
            }
            List<List<Integer>> lists = endMap.get(i);
            if (lists != null) {
                for (List<Integer> offer : lists) {
                    Integer start = offer.get(0);
                    Integer gold = offer.get(2);
                    int value = start > 0 ? arr[start - 1] : 0;
                    arr[i] = Math.max(arr[i], value + gold);
                }
            }
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maximizeTheProfit(4, Arrays.asList(
//                Arrays.asList(0, 0, 5),
//                Arrays.asList(3, 3, 1),
//                Arrays.asList(1, 2, 5),
//                Arrays.asList(0, 0, 7)
//        )));

        Random random = new Random();
        List<List<Integer>> offers = new ArrayList<>();
        int length = random.nextInt(10000);
        for (int i = 0; i < 100000; i++) {
            int end = random.nextInt(length);
            int start = random.nextInt(end + 1);
            int gold = random.nextInt(10000);
            List<Integer> list = Arrays.asList(start, end, gold);
            offers.add(list);
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().maximizeTheProfit0(length, offers));
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().maximizeTheProfit(length, offers));
        System.out.println(System.currentTimeMillis());
    }
}
