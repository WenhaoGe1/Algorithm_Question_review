import java.util.Comparator;
import java.util.*;

abstract class TopFrequentWordsSolver{
	protected static Comparator<Map.Entry<String, Integer>> byDescendingFrequency = 
			Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().
			thenComparing(Map.Entry<String, Integer>::getKey);
}

class TopFrequentWordsSolverUsingMinHeap extends TopFrequentWordsSolver{
	//@Override
	protected List<String> topKFrequentWordsFromWordCounts(HashMap<String, Integer> wordCounts, int k){
		PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(k, byDescendingFrequency.reversed());
		Iterator<Map.Entry<String, Integer>> iter = wordCounts.entrySet().iterator();
		for (int i = 0; i < k; ++i) {
			q.add(iter.next());
		}
		for (int i = k; i < wordCounts.size(); ++i) {
			Map.Entry<String, Integer> wordCount = iter.next();
			if (byDescendingFrequency.compare(wordCount, q.peek()) < 0) {
				q.remove();
				q.add(wordCount);
			}
		}
		
		List<String> result = new ArrayList<>();
		while (!q.isEmpty()) {
			result.add(q.remove().getKey());
		}
		Collections.reverse(result);
		return result;
	}
	
}



