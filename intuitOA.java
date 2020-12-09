import java.io.*;
import java.util.*;

public class intuitOA {
	static boolean[][] visited;
	static void findWord(String word, String[][] grid) {
	    
		if (word == null || word.length() == 0) {
	    	System.out.println("None");
	    }
		
		visited = new boolean[grid.length][grid[0].length];
		
		Deque<List<Integer>> result = new ArrayDeque<>();
		List<Integer> cur = new ArrayList<>();
		
	   
	    for (int i = 0; i < grid.length; i++) {
	    	for (int j = 0; i < grid[i].length; j++) {
	    		if (word.charAt(0) == grid[i][j].charAt(0) && exist(result, cur, grid, i, j, word, 0)) {
	    			
	    			print(result);
	    			return;
	    		}
	    	}
	 
	    }
	    // no such result
	    System.out.println("None");
	}
	
	public static boolean exist(Deque<List<Integer>> result, List<Integer> cur, String[][] grid, int i, int j, String word, int index) {
		if (index == word.length()) {
//			cur.add(j - 1);	
//			cur.add(i);
//			result.add(new ArrayList<Integer>(cur));
//			cur.remove(cur.size() - 1);
//			cur.remove(cur.size() - 1);
			return true;	
		}
		
		if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j].charAt(0) != word.charAt(index) || visited[i][j]) {
			return false;
		}
		
		visited[i][j] = true;
		if (
			exist(result, cur, grid, i + 1, j, word, index + 1) ||
			
			exist(result, cur, grid, i, j + 1, word, index + 1)) {
				cur.add(i);
				cur.add(j);	
				result.addFirst(new ArrayList<Integer>(cur));
				
				cur.remove(cur.size() - 1);
				cur.remove(cur.size() - 1);
				return true;
		}
		
		visited[i][j] = false;
		return false;
	} 
	
	public static void print(Deque<List<Integer>> result) {
		for (List<Integer> l : result) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		String input = new String("catnip");
		
		String[][] grid = {
				{"c", "r", "c", "a", "r", "s"},
				{"a", "b", "i", "t", "n", "b"},
				{"t", "f", "n", "n", "t", "i"},
				{"x", "s", "i", "i", "p", "t"},
		};
		findWord(input, grid);
	}
}

