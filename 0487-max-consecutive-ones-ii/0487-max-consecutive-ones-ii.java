class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0, left=0, right=0, numZeros=0;
        while(right < nums.length){
            if(nums[right]==0){
                numZeros++;
            }
            while(numZeros == 2){
                if(nums[left] == 0){
                    numZeros --;
                }
                left ++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}