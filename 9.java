public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        int sign = 1, start = 0;         
        long res = 0;                 
        if(str.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        if(str.charAt(0) == '+') {
            start = 1;
        }
        for(int i = start; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res = 10*res + sign*(int)(str.charAt(i) - '0');        
                if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
           else break;
        }
        return (int)res;
    }
}
