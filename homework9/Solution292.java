/*
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
*/

public class Solution292 {
    public static boolean canWinNim(int n) {
    	/*if (n<=0) return false;
        else if (n==1 || n==2 ||n==3) return true;
        else {
        	if (canWinNim(n-1) || canWinNim(n-2) ||canWinNim(n-3)) return false;
        	else return true;
        }*/

        if (n<=0) return false;
        else {
        	if (n%4==0) return false;
        	else return true;
		}
    }

    public static void main(String[] args) {
    	//System.out.println(canWinNim(3));
    }
}