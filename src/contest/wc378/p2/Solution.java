package contest.wc378.p2;

class Solution {
    public int maximumLength(String s) {
        int length = s.length();
        int result = -1;

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            for (int j = i; j < length; j++) {
                if (s.charAt(j) == currentChar) {
                    int count = countSubstrings(s, s.substring(i, j + 1));

                    if (count >= 3) {
                        result = Math.max(result, j - i + 1);
                    }
                } else {
                    break; // Break if a different character is encountered
                }
            }
        }
        return result;
    }


    public static int countSubstrings(String mainString, String subString) {
        int count = 0;
        int index = mainString.indexOf(subString);

        while (index != -1) {
            count++;
            index = mainString.indexOf(subString, index + 1);
        }

        return count;
    }
}
