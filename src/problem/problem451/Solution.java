package problem.problem451;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map.Entry<Character, Integer>[] entries = new Map.Entry[map.size()];
        int mapIndex = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            entries[mapIndex++] = entry;
        }
        quickSort(entries, 0, entries.length - 1);
        for (Map.Entry<Character, Integer> entry : entries) {
            Character c = entry.getKey();
            Integer count = entry.getValue();
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }

    private void quickSort(Map.Entry<Character, Integer>[] entries, int low, int high) {
        if (low >= high) return;
        Map.Entry<Character, Integer> key = entries[low];
        int left = low;
        int right = high;

        while (left < right) {
            while (left < right && key.getValue() >= entries[right].getValue())
                right--;
            while (left < right && key.getValue() <= entries[left].getValue())
                left++;
            if (left < right) swap(entries, left, right);
        }
        swap(entries, low, left);

        quickSort(entries, low, left - 1);
        quickSort(entries, right + 1, high);
    }

    private void swap(Map.Entry<Character, Integer>[] entries, int left, int right) {
        Map.Entry<Character, Integer> entry = entries[left];
        entries[left] = entries[right];
        entries[right] = entry;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
    }
}
