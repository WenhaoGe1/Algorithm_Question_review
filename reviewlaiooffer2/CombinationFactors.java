package reviewlaiooffer2;

import java.util.ArrayList;
import java.util.List;

public class CombinationFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {6, 4, 3, 2};
		List<List<Integer>> res = combinations(12, array);
		System.out.print(res);
	}
	private static List<List<Integer>> combinations(int target, int[] array) {
		List<List<Integer>> res = new ArrayList<>();
		
		dfs(target, array, res, new ArrayList<Integer>(), 0, 1);
		return res;
	}
	private static void dfs(int target, int[] array, List<List<Integer>> res, List<Integer> cur, int index, int product) {
		if (product == target) {
			if (cur.size() > 1) {
				res.add(new ArrayList<Integer>(cur));
			}
			return;
		}
//		if (product * array[index] == target) {
//			cur.add(array[index]);
//			res.add(new ArrayList<Integer>(cur));
//			return
//		}
		if (index == array.length) {
			return;
		
		}
		for (int i = target / product / array[index]; i >= 0; i--) {
			if (i == 0) {
				dfs(target, array, res, cur, index + 1, product);
			} else {
				cur.add(array[index]);
				dfs(target, array, res, cur, index + 1, product * i * array[index]);
				cur.remove(cur.size() - 1);
			}
		}
	}

}
