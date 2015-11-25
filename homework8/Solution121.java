public class Solution121 {
	/*Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),design an algorithm to find the maximum profit.*/
	public int maxProfit(int[] prices) {
		int resu = 0;
		if (prices.length<2) return resu;
		else {
			int min = prices[0];
			for (int i=1; i<prices.length; i++) {
					if (prices[i] < min) min = prices[i];
					else {
						if (prices[i]-min>resu) resu = prices[i]-min;
					}
				}
			return resu;
		}
	}
}