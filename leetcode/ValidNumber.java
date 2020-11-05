// problem: https://leetcode.com/problems/valid-number/

class ValidNunber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;

        char ch[] = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;

        while (start < ch.length && ch[start] == ' ') start++;
        while (end > -1 && ch[end] == ' ') end--;
        if (start == ch.length) return false;

        int i = start;
        boolean digit = false;
        boolean dot = false;
        boolean sign = false;
        while (i <= end) {
            if (ch[i] == 'e') {
                i++;
                break;
            } else if (Character.isDigit(ch[i])) {
                digit = true;
            } else if ((ch[i] == '-' || ch[i] == '+') && !digit && !dot && !sign) {
                sign = true;
            } else if (ch[i] == '.' && !dot) {
                dot = true;
            } else {
                return false;
            }
            i++;
        }

        if (i > end) return digit && ch[i - 1] != 'e';

        boolean edigit = false;
        sign = false;
        while (i <= end) {
            if (Character.isDigit(ch[i])) {
                edigit = true;
            } else if ((ch[i] == '-' || ch[i] == '+') && !edigit && !sign) {
                sign = true;
            } else {
                return false;
            }
            i++;
        }

        return digit && edigit;
    }
}