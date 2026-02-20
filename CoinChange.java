class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int res = func(0,amount,coins,dp,n);
        if(res == Integer.MAX_VALUE)
            return -1;
        else
            return res;
    }
    public int func(int i,int t,int arr[],int dp[][],int n){
        if(t == 0)
        return 0;
        if(t<0 || i>=n)
        return Integer.MAX_VALUE;
        if(dp[i][t] != -1)
        return dp[i][t];
        int take = Integer.MAX_VALUE;
        if(arr[i]>0){
            take = func(i,t-arr[i],arr,dp,n);
            if(take != Integer.MAX_VALUE)
                take++;
        }
        int nottake = func(i+1,t,arr,dp,n);
        dp[i][t] = Math.min(take,nottake);
        return dp[i][t];
    }
}
