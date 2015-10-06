public class Solution58 {
    public static int lengthOfLastWord(String s) {
	    if (s.length() == 0) return 0;
	    else{
	        char[] sc = s.toCharArray();
	        int count = 0;
	        int len = sc.length;
	        while (len>0 && sc[len-1] == ' ') len -= 1;
	        for (int i=0; i<len; i++) {
		        if (sc[i] == ' ') count = i+1;
	        }
	        return len - count;
    	}
    }

	static int a = lengthOfLastWord("    ");
    public static void main(String[] args) {
    	System.out.println(a);
    }
}