import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class closestK {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 8, 9};
		int k = 3;
		int target = 4;
		Queue<Integer> result = new ArrayDeque<>();
		
		result = closestK(array, k, target);
		System.out.println(result.toString());
	}
	public static Queue<Integer> closestK(int[] array, int k, int target){
		if (array == null || array.length == 0){
			return new ArrayDeque<Integer>(); 
		}
		Queue<Integer> result = new ArrayDeque<>();
		int left = 0;
		int right = array.length - 1;
		int closestIndex = -1;
		while (right - left <= 1){
			int mid = left + right - left / 2;
			if (array[mid] == target){
				result.offer(array[mid]);
				closestIndex = mid;
				left = mid - 1;
				right = mid + 1;
				break;
			}
			else if (array[mid] > target){
				right = mid;
			}
			else {
				left = mid;
			}
		} 

		if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)){
			closestIndex = left;
		}
		else{
			closestIndex = right;
		}	
		while (left >= 0 || right <= array.length - 1){
			while (result.size() <= k){
				if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)){
					result.offer(array[left]);
					left--;
				}
				else{
					result.offer(array[right]);
					right++;
				}
			}
		}
		return result;
	}
}
