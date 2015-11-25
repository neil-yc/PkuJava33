public class Solution171 {
	/*
	Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    */
	public static int titleToNumber(String s) {
		char[] temp = s.toCharArray();
		int resu = 0;
		//for (int i=temp.length-1; i>=0; i--) System.out.println((int)temp[i]-64);
		for (int i=0; i<temp.length; i++) {
			resu *= 26;
			resu += (int)temp[i]-64;
		}
		return resu;
 	}

 	public static void main(String[] args) {
 		System.out.println(titleToNumber("AZ"));
 	}
}