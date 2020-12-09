package reviewlaiooffer2;
import java.util.*;
public class FactorCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = combinations(12);
		System.out.print(res);
	}
	
	  public static List<List<Integer>> combinations(int target) {
		    // Write your solution here
		    List<List<Integer>> res = new ArrayList<>();
		    if (target <= 3) {
		      return res;
		    }
		    List<Integer> factors = findFactors(target);

		    Collections.reverse(factors);
		    System.out.print(factors);
		    List<Integer> cur = new ArrayList<>();
		    
		    dfs(target, 0, cur, res, factors);
		    return res;
		  }

	  private static List<Integer> findFactors(int target) {
	    List<Integer> factors = new ArrayList<>();
	    for (int i = 2; i <= (target / 2) ; i++) {
	      if (target % i == 0) {
	        factors.add(i);
	      }
	    }
	    return factors;
	  }
	  
	  private static void dfs(int rem, int index, List<Integer> cur, List<List<Integer>> res, List<Integer> factors) {
	    if (rem <= 1) {
	    	if (cur.size() > 1) {
		    	List<Integer> sol = new ArrayList<Integer>(cur);
		    	res.add(sol);
	    	}
	    	return;
	    } 
	    if (index == factors.size()) {
	    	return;
	    }

	    for (int i = 0; i * factors.get(index) <= rem; i++) {
	    	if (i == 0) {
	    		dfs(rem, index + 1, cur, res, factors);
	    	} else {
		    	cur.add(factors.get(index));
		    	dfs(rem / (i * factors.get(index)), index + 1, cur, res, factors);
		    	cur.remove(cur.size() - 1);
	    	}
	    }
	  }
}
