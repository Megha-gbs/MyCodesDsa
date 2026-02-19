class Solution {
    public int trap(int[] nums) {
       int ans = 0;
        int pmax[] = constructpmax(nums);
        int smax[] = constructsmax(nums);
        for(int i = 0;i<nums.length;i++){
            int l = pmax[i];
            int r = smax[i];
            int level = Math.min(l,r);
            int water = (level - nums[i]);
            ans += water;
        } 
        return ans;
    }
    public int[] constructpmax(int []nums){
        int pmax[] = new int[nums.length];
        pmax[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            pmax[i] = Math.max(pmax[i-1],nums[i]);
        }
        return pmax;
    }
    public int[] constructsmax(int []nums){

        int smax[] = new int[nums.length];
        smax[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){
            smax[i] = Math.max(smax[i+1],nums[i]);
        }
        return smax;
    }
}
