class Solution {
    public int findGCD(int[] nums) {
        int a = nums[0], b= nums[0];
        for(int i=1; i<nums.length;i++){
            a = Math.min(a, nums[i]);
            b = Math.max(b, nums[i]);
        }
        while(a > 0){
            int temp = a;
            a = b%a;
            b = temp;
        }
        return b;
    }
        
}