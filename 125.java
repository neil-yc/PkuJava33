public class Solution {
    public boolean isPalindrome(String s) {
        boolean res = false;
        //Unicode 编码并不只是为某个字符简单定义了一个编码，而且还将其进行了归类。
		///pP 其中的小写 p 是 property 的意思，表示 Unicode 属性，用于 Unicode 正表达式的前缀。
		//大写 P 表示 Unicode 字符集七个字符属性之一：标点字符
		//处理大小写 aA 应该返回true
		s = s.toLowerCase();
		String[] sArray = s.trim().split("\\pP|\\pS|\\s+");		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<sArray.length;i++){
		    sb.append(sArray[i]);
		}
// 		for(String str : sArray){
// 			sb.append(str);
// 		}
		
		return sb.toString().equals(sb.reverse().toString());
    }
}