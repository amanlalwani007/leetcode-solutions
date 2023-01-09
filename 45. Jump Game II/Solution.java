class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[n-1] = 0;

        for(int i = n-2; i >= 0 ; i--){
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i] && i+j < n; j++){
                min = Math.min(min, dp[i+j]);
            } 
            if(min == Integer.MAX_VALUE)
                dp[i] = min;
            else            
                dp[i] = 1 + min;
        }
       return dp[0]; 
    }
}