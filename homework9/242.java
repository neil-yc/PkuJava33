public class Solution {
    public boolean isAnagram(String s, String t) {
        
		//如果长度不一样，一定false
		if(s.length() != t.length()){
			return false;
		}
		if(s.equals("") && t.equals("")){
			return true;
		}
		char[] ss = s.toCharArray();
		char[] st = t.toCharArray();
		//使用Apache 的 ArrayUtils
// 		if(cs.length > 0){
// 			for(char a : cs){
// 				if(ArrayUtils.contains(ct, a)){
// 					ArrayUtils.removeElement(ct, a);
// 				}else{
// 					return false;
// 				}
				
// 			}
// 		}
		List tl = new ArrayList<>();
		
		for(Character ct : st){
			tl.add(ct);
		}
		
		if(ss.length > 0){
			for(Character a : ss){
				if(tl.contains(a)){
					tl.remove(a);
				}else{
					return false;
				}
				
			}
		}
		
		return true;
    }
}