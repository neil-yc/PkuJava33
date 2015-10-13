public class Solution191 {
    // you need to treat n as an unsigned value
	static int count(int m){//求无符号数的二进制形式中1的位数
		int flag = 0;
	    while (m!=0) {
		    flag += m % 2;
		    m = m / 2;
	    }
	    return flag;
	}
    
    public static int hammingWeight(int n) {
	    if (n<0) {//若为负数
		    n = ~n;//逐位取反
		    return Integer.SIZE - count(n);//Integer.SIZE为系统默认的字节位数
	    }
		else return count(n);
    }
    
	static int a = hammingWeight(-128);
    public static void main(String[] args) {
    	System.out.println(a);
    }
}