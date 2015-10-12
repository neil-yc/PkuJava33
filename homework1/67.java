public class Solution {
    public String addBinary(String a, String b) {
        String rs = "";
		int al = a.length()-1;
		int bl = b.length()-1;
//		int sbi = 0;//insert 的偏移量
		int m = 0;//是否进位
		StringBuilder sb = new StringBuilder();
		if(al > bl){
			for(int i=al-bl;i>0;i--){
				b = '0'+ b;
			}
			bl = al;
		}else{
			for(int i=bl-al;i>0;i--){
				a = '0'+ a;
			}
			al = bl;
		}
		
		do{
//			int ta = Integer.parseInt(String.valueOf(a.charAt(al)), 2);
//			int tb = Integer.parseInt(String.valueOf(b.charAt(bl)), 2);
			if(m == 0){
//				if((ta^tb) == 1){
//					sb.insert(sbi, '1');
//				}else{
//					sb.insert(sbi, '0');
//				}
				
				
				if(a.charAt(al) == '1' && b.charAt(bl) == '1'){
					sb.insert(0, '0');
					if(al==0 || bl==0){
						sb.insert(0, '1');
						break;
					}
					m = 1;
				}else if(a.charAt(al) == '1' || b.charAt(bl) == '1'){
					sb.insert(0, '1');
//					if(al==0 || bl==0){
//						sb.insert(0, '1');
//						break;
//					}
					m = 0;
				}else{
					sb.insert(0, '0');
					m = 0;
				}
			}else{
				if(a.charAt(al) == '1' && b.charAt(bl) == '1'){
					sb.insert(0, '1');
					if(al==0 || bl==0){
						sb.insert(0, '1');
						break;
					}
					m = 1;
				}else if(a.charAt(al) == '1' || b.charAt(bl) == '1'){
					sb.insert(0, '0');
					if(al==0 || bl==0){
						sb.insert(0, '1');
						break;
					}
					m = 1;
				}else{
					sb.insert(0, '1');
					m = 0;
				}
			}
			al--;
			bl--;
		}while(al >= 0 || bl >= 0);
		
		rs = sb.toString();

		return rs;
    }
}