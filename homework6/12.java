public class Solution {
    public String intToRoman(int num) {
        //基本字符：I、V、X、L、C、D、M
		//组数规则：
		//V 和X 左边的小数字只能用Ⅰ
		//L 和C 左边的小数字只能用X
		//D 和M 左边的小数字只能用C
		//根据组合规则，列举出所有可能的项，然后计算的时候直接相加即可
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] elements = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			//考虑倍数的情况，根据列举的项会发现，不会出现连续三个相同的项出现
			while (num >= values[i]) {
				num = num - values[i];
				result.append(elements[i]);
			}
		}
		return result.toString();
    }
}