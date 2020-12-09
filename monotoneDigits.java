import java.util.Arrays;

public class monotoneDigits {
	// 让这个input变成一个单调递增的数，且小于等于input
	 public static int monotoneDigits(int num) {
	        // write your code here
	        int []dights = new int[10];
	        int cnt = 0;
	        int pos = 0, i;
	        // put input into dig array
	        while(num != 0){
	            dights[cnt++] = num % 10;
	            num /= 10;
	        }
	        System.out.println(Arrays.toString(dights));
	        
	        // cnt is the index of last dig + 1
	        System.out.println(cnt);
	        
	        // if dights[i] > dights[i - 1], i-th num--, and pos is the last dig
	        for(i = 1; i < cnt; i++){
	        	if(dights[i] > dights[i - 1]){
	            	dights[i]--;
	            	pos = i;
	            }
	        }
	        
	        // 
	        for(i = 0; i < pos; i++){
	            dights[i] = 9;
	        }

	        int ans = 0;
	        for(i = cnt - 1; i >= 0; i--){
	        	ans = ans * 10 + dights[i];
	        }
	        return ans;
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;
		result = monotoneDigits(8);
		System.out.println(result);
		
	}

}
