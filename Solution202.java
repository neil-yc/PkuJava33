public class Solution202 {
	static boolean yorn(int m) {
		int[] table = {1, 7, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};//以2^32计
	    int flag = 0;
	    for(int i=0; i<10; i++) {
		    if (m==table[i]) {
			    flag = 1;
			    break;
			}
	    }
	    if (flag==1) return true;
	    else return false;
	}

    public static boolean isHappy(int n) {
	    int b;
	    if (n<=0) return false;
	    else{
		    while(yorn(n)==false) {
			    if (n==4) break;//以1~9分别多次求幸运数可知，最终循环中均会出现4；
	    		b = 0;
	    		while(n!=0) {
		    		int a = n % 10;
	    			n = n / 10;
	    			b += a*a;
	    		}
	    		n = b;
    		}
    		return yorn(n);
	    }
    }
    
    static boolean c = isHappy(87);
	public static void main(String[] args) {
		//for(int i=0; i<20; i++)	System.out.println(b[i]);
		System.out.println(c);
		
	}
}