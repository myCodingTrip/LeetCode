package problem.problem345;

class Solution {
    public String reverseVowels(String s) {
        char[] res = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isVowel(s.charAt(i))) {
                res[i] = s.charAt(i);
                i++;
            }
            while (i < j && !isVowel(s.charAt(j))) {
                res[j] = s.charAt(j);
                j--;
            }
            if (i < j) {
                res[i] = s.charAt(j);
                res[j] = s.charAt(i);
                i++;
                j--;
            }
        }
        if (i == j) {
            res[i] = s.charAt(i);
        }

        return new String(res);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("ai"));
    }
}
