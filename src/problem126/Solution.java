package problem126;

import java.util.*;

//todo 34.83%
class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> wordList2 = new ArrayList<>(wordList);
        int end = wordList2.indexOf(endWord);
        int begin = wordList2.indexOf(beginWord);
        if (begin == -1) {
            wordList2.add(beginWord);
            begin = wordList2.size() - 1;
        }
        int n = wordList2.size();
        //生成图 保存每个点可到达的点
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (canTransform(wordList2.get(i), wordList2.get(j))) {
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }

        //保存每个单词到begin的距离
        Map<Integer, Integer> distance = new HashMap<>();

        bfs(g, begin, distance);
        List<List<String>> res = new ArrayList<>();
        List<Integer> oneOfRes = new ArrayList<>();
        oneOfRes.add(begin);
        dfs(g, begin, end, distance, wordList2, oneOfRes, res);

        return res;
    }

    //bfs获得每个点和begin的距离
    private void bfs(List<List<Integer>> g, int begin, Map<Integer, Integer> distance) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(begin);
        distance.put(begin, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int j : g.get(cur)) {
                if (!distance.containsKey(j)) {
                    distance.put(j, distance.get(cur) + 1);
                    queue.offer(j);
                }
            }
        }
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

    /**
     * 通过联通关系g和距离map distance获取结果
     *
     * @param g            各点之间的联通关系
     * @param cur          dfs进行到的点的index，从begin开始
     * @param end          endWord对应的index
     * @param distanceMap  保存begin到各点的距离
     * @param wordList
     * @param oneOfResList 存储一次可到达的路径
     * @param res
     */
    private void dfs(List<List<Integer>> g, int cur, int end, Map<Integer, Integer> distanceMap,
                     List<String> wordList, List<Integer> oneOfResList, List<List<String>> res) {
        if (oneOfResList.get(oneOfResList.size() - 1) == end) {
            res.add(getPath(oneOfResList, wordList));
            return;
        }
        //获取cur可到达的每个点
        for (Integer i : g.get(cur)) {
            //cur到begin的距离正好为i到begin的距离+1
            if (distanceMap.get(i) == distanceMap.get(cur) + 1) {
                oneOfResList.add(i);
                dfs(g, i, end, distanceMap, wordList, oneOfResList, res);
                oneOfResList.remove(oneOfResList.size() - 1);
            }
        }
    }

    //通过index的list获取word的list
    private List<String> getPath(List<Integer> oneOfRes, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (Integer tre : oneOfRes) {
            res.add(wordList.get(tre));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLadders("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}