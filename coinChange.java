import java.util.Arrays;
import java.util.*;

public class coinChange {
	
    public static List<Integer> coinChange(int[] coins, int amount) {
    	List<Integer> result = new ArrayList<>();

        if (coins == null || coins.length == 0){
            return result;
        }
        
        coinChange(coins, amount, 0, result);
        return result;
    }
    
    private static void coinChange(int[] coins, int amount, int index, List<Integer> result){
        if (index == coins.length - 1) {
	    	if (amount % coins[index] == 0){
	            result.add(amount / coins[index]);
	            result.remove(result.size() - 1);
	        }
	    	return;
        }
        for (int i = 0; i < amount / coins[index]; i++){
        	result.add(i);
        	coinChange(coins, amount - coins[index] * i, index + 1, result);
        	result.remove(result.size() - 1);
        }
    }
    
    public static List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<Integer> sol = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        combinations(sol, result, target, coins, 0);
        return result;
      }
    
      public static void combinations(List<Integer> sol, List<List<Integer>> result, 
                               int target, int[] coins, int index){
        if (index == coins.length - 1){
          if (target % coins[coins.length - 1] == 0){
            sol.add(target / coins[coins.length - 1]);
            result.add(new ArrayList<Integer>(sol));
            sol.remove(sol.size() - 1);
          }
          return;
        }

          // 这个coin放多少个
          for (int j = 0; j <= target / coins[index]; j++){
            sol.add(j);
            combinations(sol, result, target - coins[index] * j, coins, index + 1);
            sol.remove(sol.size() - 1);
          }
        
      }
    
    
    public static void main(String[] args) {
    	int[] input = {5, 2, 1};
    	List<List<Integer>> result = new ArrayList<>();
    	result = combinations(11, input);
    	System.out.println(result);
    }
    
}
