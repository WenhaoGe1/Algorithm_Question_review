import java.util.Arrays;

public class canPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 5};
		boolean result = false; 
		boolean w = false;
		result = canPartition(nums);

	}
	
	public static boolean canPartition(int[] nums) {
        // write your code here
        int sum = 0;
        for(int i=0; i<nums.length; i++)
            sum += nums[i];
        
        if(sum % 2 == 1)
            return false;
        
        //dp[i][j]表示在前i个物品中挑选物品是否能将容量为j的背包填满
        boolean[] dp = new boolean[(sum/2) + 1];
        
        //初始条件，第一行
        for(int i=0; i<=sum/2; i++)
            dp[i] = (i == nums[0]) ? true : false;
        
        //递推式
        for(int i=1; i<nums.length; i++){
            for(int j=sum/2; j>=nums[i]; j--){
            	System.out.println("i " + i);
            	System.out.println("j " + j);
            	System.out.println(nums[i]);
                dp[j] = dp[j] || dp[j-nums[i]];
                System.out.println(Arrays.toString(dp));
            }
        }
        
        return dp[sum/2];
    }
}
