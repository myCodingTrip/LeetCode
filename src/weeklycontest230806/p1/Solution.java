package weeklycontest230806.p1;

class Solution {
    public String finalString(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == 'i') {
                sb = new StringBuilder(sb.reverse().toString());
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().finalString("string"));
        System.out.println(new Solution().finalString("poiinter"));
        System.out.println(new Solution().finalString("goci"));
    }
}
