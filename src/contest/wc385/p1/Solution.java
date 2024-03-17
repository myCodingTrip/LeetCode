package contest.wc385.p1;

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String word1 = words[i];
                String word2 = words[j];
                if (word1.length() <= word2.length()) {
                    if (isPrefixAndSuffix(word1, word2)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean isPrefixAndSuffix(String word1, String word2) {
        return word2.startsWith(word1)
                && word2.startsWith(word1, word2.length() - word1.length());
    }
}
