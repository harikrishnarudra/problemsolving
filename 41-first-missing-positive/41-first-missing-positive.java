class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for(int i:nums){
            map.put(i, 1);
        }
        int i=1;
        for(;i<=nums.length;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return i;
        
    }
}