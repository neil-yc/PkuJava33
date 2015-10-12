public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascal = new ArrayList<>();
		int index = rowIndex;
		for(int i=0; i<rowIndex+1; i++){
			//第一层循环
			List<Integer> row = new ArrayList<>();
			for(int j=i; j>=0; j--){
				//i+1为行数
				if(i>1){
					List<Integer> temp = pascal.get(i-1);
					row.add(1);
					for(int a=0;a<temp.size()-1;a++){
						row.add(temp.get(a)+temp.get(a+1));
					}
					row.add(1);
					break;
				}else{
					row.add(1);
//					break;
				}
			}
			pascal.add(row);
		}
//		System.out.println(pascal.get(index-1));
// 		System.out.println(pascal.get(index));
		return pascal.get(rowIndex);
//		for(int i=0; i<pascal.size();i++){
//			System.out.println(pascal.get(i));
//		}
    }
}