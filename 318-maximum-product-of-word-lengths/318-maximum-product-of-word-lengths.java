class Solution {
    
    public int bitNumber(char ch){
        return (int)ch - (int)'a';
    }
    
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];
        for(int i=0;i<n;i++){
            String w = words[i];
            int bitmask = 0;
            for(char ch:w.toCharArray()){
                bitmask |= 1 << bitNumber(ch);
            }
            masks[i] = bitmask;
            lens[i] = w.length();
        }

        int maxProd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((masks[i] &   masks[j]) == 0){
                    maxProd = Math.max(maxProd, lens[i] * lens[j]);
                }
            }
        }
        return maxProd;
    }
}