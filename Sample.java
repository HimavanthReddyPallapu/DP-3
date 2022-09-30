// Time Complexity : m
// Space Complexity : m 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO, Shravya helped!


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) 
    {
     if(nums.length==0 || nums==null)
     {
         return 0;
     }
    
    int max= Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++)
    {
        max=Math.max(max,nums[i]);
    }
    
    int[] da=new int[max+1];
        
    for(int i=0;i<nums.length;i++)
    {
        da[nums[i]]+=nums[i];
    }
    
    int[][] dp=new int[max+1][2];
        
    for(int i=1;i<max+1;i++)
    {
        dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
        dp[i][1]=da[i]+dp[i-1][0];
    }
        
        return Math.max(dp[max][0],dp[max][1]);
        
    }
}
