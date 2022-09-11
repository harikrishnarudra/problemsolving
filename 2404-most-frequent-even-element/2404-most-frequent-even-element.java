class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] arr = new int[100_000];
        for(int num:nums){
            ++arr[num];
        }
        int max = 0;
        int result = -1;
        for(int i=0; i< arr.length; i+=2){
            if(max < arr[i]){
                max = arr[i];
                result = i;
            }
        }
        return result;
        
    }
}