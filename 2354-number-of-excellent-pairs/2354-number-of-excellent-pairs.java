class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        long res = 0;
        int[] bitCnt = new int[32];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                bitCnt[Integer.bitCount(nums[i])]++;
            }
        }
        
        for(int i=0;i<32;i++){
            for(int j=0;j<32;j++){
                if(i+j >=k){
                    res += bitCnt[i] * bitCnt[j];
                }
            }
        }

        return res;
    }
}