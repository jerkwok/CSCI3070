
import java.util.*;
import java.lang.*;

public class BottomUp{

	static private ArrayList<Integer> computeChange(int money, int[] coins){
		int[][] numCoins = new int[money+1][coins.length+1];
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1;i <= money;i++) {
			numCoins[i][1] = i;	
		}

		for (int i = 1;i <= coins.length;i++) {
			numCoins[1][i] = 1;	
		}


		for (int j = 2; j < coins.length; j++){
			for (int i = 1; i <= money; i++){
				if (coins[j] > i){
					numCoins[i][j] = numCoins[i][j-1];
				}else{
					numCoins[i][j] = Math.min(numCoins[i][j-1], 1 + numCoins[i-coins[j]][j]);
				}
			}
		}

		int moneyX = money;
		int coinsY = coins.length-1;
		int temp = numCoins[moneyX][coinsY];
		while(temp > 0){
			if (numCoins[moneyX][coinsY] == numCoins[moneyX][coinsY-1]){
				coinsY--;
			}else{
				result.add(coins[coinsY]);
				moneyX-=coins[coinsY];
			}
			temp = numCoins[moneyX][coinsY];
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] coins = new int[6];
		coins[1] = 1;
		coins[2] = 5;
		coins[3] = 10;
		coins[4] = 25;
		coins[5] = 100;

		System.out.println("Bottom's Up!");
		ArrayList<Integer> result;
		result = computeChange(104, coins);
		System.out.println("Coins for 104c:" + result + ", Number of coins:" + result.size());
		result = computeChange(122, coins);
		System.out.println("Coins for 122c:" + result + ", Number of coins:" + result.size());
		result = computeChange(141, coins);
		System.out.println("Coins for 141c:" + result + ", Number of coins:" + result.size());
		result = computeChange(156, coins);
		System.out.println("Coins for 156c:" + result + ", Number of coins:" + result.size());
		result = computeChange(157, coins);
		System.out.println("Coins for 157c:" + result + ", Number of coins:" + result.size());
		result = computeChange(167, coins);
		System.out.println("Coins for 167c:" + result + ", Number of coins:" + result.size());
		result = computeChange(188, coins);
		System.out.println("Coins for 188c:" + result + ", Number of coins:" + result.size());
		result = computeChange(189, coins);
		System.out.println("Coins for 189c:" + result + ", Number of coins:" + result.size());
		result = computeChange(200, coins);
		System.out.println("Coins for 200c:" + result + ", Number of coins:" + result.size());
	}
}