class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        long res = 0;
        int[] bitCnt = new int[32];
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            bitCnt[Integer.bitCount(iterator.next())]++;
        }

        for(int i=0;i<bitCnt.length;i++){
            for(int j=0;j<32;j++){
                if(i+j >=k){
                    res += bitCnt[i] * bitCnt[j];
                }
            }
        }

        return res;
    }
}