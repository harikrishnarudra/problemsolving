class Solution {
    public int countNicePairs(int[] A) {
        int res = 0, mod = (int)1e9 + 7;
        Map<Integer, Integer> count = new HashMap<>();;
        for (int a : A) {
            int b = rev(a), v = count.getOrDefault(a - b, 0);
            count.put(a - b, v + 1);
            res = (res + v) % mod;
        }
        return res;
        
    }
    
    private int rev(int num){
        int rev = 0;
        while(num > 0){
            rev = rev*10 + num %10;
            num = num/10;
        }
        return rev;
    }
}