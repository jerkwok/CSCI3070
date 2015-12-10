
import java.util.*;
import java.lang.*;

public class GreedyChange{

	static ArrayList<Integer> result = new ArrayList<Integer>();

	private static void computeChange(int money, int[] coins){
		if (money == 0){
			return;
		}

		for (int i = coins.length-1;i>=0 ;i-- ) {
			if (money >= coins[i]){
				result.add(coins[i]);
				computeChange(money-coins[i], coins);
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] coins = new int[5];
		coins[0] = 1;
		coins[1] = 5;
		coins[2] = 10;
		coins[3] = 25;
		coins[4] = 100;

		System.out.println("Greedy!");
		computeChange(104, coins);
		System.out.println("Coins for 104c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(122, coins);
		System.out.println("Coins for 122c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(141, coins);
		System.out.println("Coins for 141c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(156, coins);
		System.out.println("Coins for 156c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(157, coins);
		System.out.println("Coins for 157c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(167, coins);
		System.out.println("Coins for 167c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(188, coins);
		System.out.println("Coins for 188c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(189, coins);
		System.out.println("Coins for 189c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
		computeChange(200, coins);
		System.out.println("Coins for 200c:" + result + ", Number of coins:" + result.size());
		result = new ArrayList<Integer>();
	}
}