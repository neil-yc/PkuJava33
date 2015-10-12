public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            //控制外层循环,行数
            List<Integer> row = new ArrayList<>();
            for(int j=i; j>=0; j--){
                //控制每行的个数
                if(i>1){
                    List<Integer> temp = pascal.get(i-1);
                    row.add(1);
                    for(int a=0; a<temp.size()-1; a++){
                        row.add(temp.get(a)+temp.get(a+1));
                    }
                    row.add(1);
                    break;
                }else{
                    row.add(1);
                    //break;
                }
            }
            pascal.add(row);
        }
        return pascal;
    }
}