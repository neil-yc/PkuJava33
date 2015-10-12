public class Solution {
    public int reverse(int x) {
        int result = 0;
		Integer xm = x;//转换成Integer类型
		String rex = xm.toString();
		int a = 0;
		StringBuilder sb = new StringBuilder();
		char[] xa = rex.toCharArray();
		if(xa[0] == '-'){
			sb.append('-');
			a = 1;
		}
		for(int i=xa.length-1;i>=a;i--){
			sb.append(xa[i]);
			result = Integer.parseInt(sb.toString());
			//MAX_VALUE必须除以10，否则parseInt会报错
			if(Math.abs(result) > Integer.MAX_VALUE/10 && i==a+1){
//				System.out.println(0);
				return 0;
			}
		}
//		if(xa[0] == '-'){
//			sb.insert(0,'-');
//			sb.deleteCharAt(sb.length()-1);
//		}
//		sb.reverse();
//		rex = sb.toString();
//		result = Integer.parseInt(rex);
//		if(result > Integer.MAX_VALUE){
//			return 0;
//		}
//		System.out.println(result);
//      在比较的时候可以新建double类型变量去存储result，但是后来测试发现还不如上面的方法

//		网上找的比较优秀的解法：

//		public static int reverse(int x) {
//	        int result = 0;
//	        while(x!=0){
//	            if (Math.abs(result) > Integer.MAX_VALUE / 10) {         
//	            	return 0;
//	            }
//	            result = result*10 + x%10;
//	            x /= 10;                                    
//	        }
//	        System.out.println(result);
//	        return result;
//	    }
		
		return result;
        
    }
}