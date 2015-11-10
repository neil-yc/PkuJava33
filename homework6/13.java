public class Solution {
    public int romanToInt(String s) {
        char[] elements = s.toCharArray();
		int result = 0;
		//存取前一个数的值
		int fore = 0;
		int current = 0;
		//创建罗马数字的键值对
//		Map<String, Integer> values = new HashMap<String, Integer>();
		Map<Character, Integer> values = new HashMap<Character, Integer>();
		values.put('M', 1000);
		values.put('D', 500);
		values.put('C', 100);
		values.put('L', 50);
		values.put('X', 10);
		values.put('V', 5);
		values.put('I', 1);
		
		//初始化fore
		fore = values.get(elements[0]);
		for(int i = 0; i < elements.length; i++){
			//如果发现前一个数字比后一个数字大，则减两次前一个数字
			current = values.get(elements[i]);
			if(fore < current){
				result = result + current - 2*fore;
			}else{
				result += current;
			}
			//设置前一个数字的值
			fore = current;
		}
		
		return result;
    }
}