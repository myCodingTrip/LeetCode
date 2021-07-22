package problem8;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("2147483648"));
        ;
    }

    /**
     * 字符串转数字
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        char[] cArr = str.toCharArray();
        if (str.length() == 0) return 0;
        //是否为负数
        boolean minus = false;
        if (cArr[0] == '+' || cArr[0] == '-') {
            str = str.substring(1, cArr.length);
            if (cArr[0] == '-') minus = true;
            cArr = str.toCharArray();
        }
        //拼成可直接解析的数字字符串
        StringBuilder sb = new StringBuilder();
        //第一个字符是否为数字
        boolean canParse = false;
        //是否已经跳过了前缀的0
        boolean numStart = false;
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                if (canParse == false) {
                    canParse = true;
                }
                if (c != '0' && numStart == false) numStart = true;
                if (numStart)
                    sb.append(c);
            } else {
                if (canParse) {
                    break;
                } else {
                    return 0;
                }
            }
        }
        str = sb.toString();
        if (str.length() >= 11) {
            str = str.substring(0, 11);
        }
        if (str.length() == 0) return 0;
        //先使用long接收防止溢出
        Long l = Long.valueOf(str);
        if (minus) l = -l;
        if (l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return l.intValue();
    }

}