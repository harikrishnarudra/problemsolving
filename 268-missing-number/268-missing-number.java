class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]!=0 && nums[i]!=i+1){
                int temp = nums[i];
                int numTemp = nums[i]-1;
                nums[i] = nums[numTemp];
                nums[numTemp] = temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                return i+1;
            }
        }
        return 0;
        
        
    }
}