class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] seen = new int[60];
        for(int t:time){
            count += seen[(60 -(t % 60)) % 60];
            seen[(t%60)] += 1;
        }
        return count;
    }
}