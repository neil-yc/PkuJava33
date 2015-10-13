public class Solution67 {
    public static String addBinary(String a, String b) {
	    char[] m,n;
	    int min;
        if (a.length() < b.length()) {
	        m = a.toCharArray();
        	n = b.toCharArray();
	        min = m.length;
        }
        else {
	        m = b.toCharArray();
	        n = a.toCharArray();
			min = m.length;
		}
		
		char[] sum = new char[n.length+1];
		for (int i=0; i<n.length+1; i++) sum[i] = '0';
		//for(int i=0; i<n.length+1; i++) System.out.println(sum[i]);
		int p = n.length - m.length;
		char flag = '0';
		
        for(int i=min-1; i>=0; i--) {
	        if (m[i]=='1' && n[i+p]=='1') {
			        sum[i+p+1] = flag;
			        flag = '1';
		    }
	        else if (m[i]=='0' && n[i+p]=='0') {
		        sum[i+p+1] = flag;
		        flag = '0';
		    }
	        else {
		        if (flag=='1') sum[i+p+1] = '0';
		        else sum[i+p+1] = '1';
	        }
        }

        for(int i=p-1; i>=0; i--) {
	        if (flag=='0') sum[i+1] = n[i];
	        else if (n[i]=='0') {
		        sum[i+1] = '1';
		        flag = '0';
	        }
	        else sum[i+1] = '0';
        }

        if (flag=='1') {
	        sum[0] = '1';
	        String s = new String(sum);
	        return s;
        }
        else {
	        String s = new String(sum);
	        return s.substring(1);
        }
        //return sum;
    }

	static String a = addBinary("10001","1011");
	//static String a = addBinary("10001","1011");
	
    public static void main(String[] args) {
	    //for(int i=0; i<a.length; i++) System.out.println(a[i]);
	    System.out.println(a);
    }
}