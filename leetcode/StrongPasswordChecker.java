// Problem: https://leetcode.com/problems/strong-password-checker/

class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        char ch[] = s.toCharArray();
        int a = 1, A = 1, d = 1;
        int dups[] = new int[ch.length];
        
        // verify if there is any problem
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) { A = 0; }
            else if (Character.isLowerCase(ch[i])) { a = 0; }
            else if (Character.isDigit(ch[i])) { d = 0; }
        }
        
        int changes = a + A + d;
        // here the insert operation has more power
        if (ch.length < 6) {
            return Math.max(changes, 6 - ch.length);
        }
        
        // from now we only use remove and update operation, where remove has more power
        // count the size of duplications sequence
        for (int i = 0; i < ch.length;) {
            int j = i;
            while (i < ch.length && ch[i] == ch[j]) { i++; }
            dups[j] = i - j;
        }
        
        int overLen = Math.max(ch.length - 20, 0);
        int res = overLen;
        
        // trying do divide the remove between the most number of duplicated sequences
        // so we have the most of 3m + 2 sequences
        for (int k = 1; k < 3; k++) {
            for (int i = 0; i < dups.length && overLen > 0; i++) {
                if (dups[i] >= 3 && dups[i] % 3 == (k - 1)) {
                    dups[i] -= Math.min(overLen, k);
                    overLen -=k;
                }
            }
            if (overLen <= 0) { break; }
        }
        
        int leftOver = 0;
        for (int i = 0; i < dups.length; i++) {
            // if there is characters to remove then remove the max of character
            // of each duplicated sequence to make the sequence size 2
            if (dups[i] >= 3 && overLen > 0) {
                int need = dups[i] - 2;
                dups[i] -= Math.min(need, overLen);
                overLen -= need;
            }
            // if there is duplication but no need to remove we only need size / 3 replaces
            if (dups[i] >= 3) { leftOver += dups[i] / 3; }
        }
        
        // there is sobreposition between the replaces of changes and leftOver
        res += Math.max(changes, leftOver);
        return res;
    }
}
