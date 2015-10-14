/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
        
        /*
        int[] a={1,2,3,4};
      
        int[] a = new int[10];
        System.out.println("please input ten numbers:");
        
        Scanner scanner = new Scanner (System.in);   //为什么不弹出IOException e异常	
        while(i<10){
			 int n=0;
           //n=System.in.read();
             n = scanner.nextInt ();
             a[i]=n;
		 }
		System.out.println("please give a number:");
		  
		
		 //int num=3;
		 //num=scanner.nextInt ();
		 
		 int i=0;
		 for(i=2;i<3;i++){
			 a[i]=a[++i];
		 }
		 for(i=0;i<2;i++){
			 System.out.print(a[i]+"->");
		 }	 
		 System.out.print(a[i]);*/
    }
}