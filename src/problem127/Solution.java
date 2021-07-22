package problem127;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    //8.34%——>45.14%
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean[] visited = new boolean[wordList.size()];
        int endIndex = wordList.indexOf(endWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j]) {
                        String word = wordList.get(j);
                        if (canTransform(poll, word)) {
                            if (j == endIndex) {
                                return res + 1;
                            }
                            queue.offer(word);
                            visited[j] = true;
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }

    private boolean canTransform(String word1, String word2) {
        int diff = 0;
        int len = word1.length();
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}