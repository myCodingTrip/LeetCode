package problem.problem127;

import java.util.*;

class Solution2 {

    //575 ms 45.14%——>67ms 69.58%
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> set = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < poll.length(); j++) {
                    char[] tempStr = poll.toCharArray();
                    for (int k = 0; k < 26; k++) {
                        tempStr[j] = (char) ('a' + k);
                        String str = String.valueOf(tempStr);
                        if (set.contains(str)) {
                            if (str.equals(endWord)) return res + 1;
                            queue.offer(str);
                            set.remove(str);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
