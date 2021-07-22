package problem125;

class Solution {

    //8ms
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isValidChar(chars[i]))
                i++;
            while (i < j && !isValidChar(chars[j]))
                j--;
            if (chars[i] != chars[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isValidChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("."));
    }
}