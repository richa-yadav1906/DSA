class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        int freq=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[ans]){
                freq++;
            }
            else{
                freq--;
            }
            if(freq==0){
                ans=i;
                freq=1;
            }
            
        }
        return nums[ans];

    }
}