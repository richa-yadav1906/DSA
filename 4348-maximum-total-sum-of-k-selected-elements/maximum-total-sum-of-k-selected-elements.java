class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        long sum=0;
        int len=nums.length;
         Arrays.sort(nums);
       
        for(int i=len-1;i>=len-k  ;i--){
            if(mul>1){
            sum += (long)mul*nums[i];
            }
            else{
            sum += nums[i];
            }
            mul--;
        }
               return sum;

    }
}