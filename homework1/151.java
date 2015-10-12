public class Solution {
    public String reverseWords(String s) {
//		Pattern p = Pattern.compile("\\s+");
//		Matcher m = p.matcher(s);
//		s = m.replaceAll(" ");
		String rs = "";
//		Stack<String> ws = new Stack<String>();
		String[] wl;
		StringBuffer sb = new StringBuffer();
//		do{
//		wl = s.trim().split(" ");
		wl = s.trim().split("\\s+");
//		}while(wl.toString().contains(" "));
		
		if(wl.length == 0){
			return "";
		}
		
		for(int i=wl.length-1; i>=0; i--){
//			System.out.println(wl[i]);
//			System.out.println(" ");
			sb.append(wl[i]);
			sb.append(" ");
			
		}
		sb.deleteCharAt(sb.length()-1);
		rs = sb.toString();
		return rs;
//		System.out.println(ws.size());
//		for(int i=0; i<ws.size(); i++){
//			System.out.println(ws.size());
//			sb.append(ws.pop());
//			sb.append(" ");
//			System.out.println(ws.size());
//		}
//		System.out.println(ws.size());
//		sb.deleteCharAt(sb.length()-1);
//		rs = sb.toString();
//		System.out.println(rs);
    }
}