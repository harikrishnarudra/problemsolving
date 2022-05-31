class Solution {
    
    public int bitNumber(char ch){
        return (int)ch - (int)'a';
    }
    
    public int maxProduct(String[] words) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String w = words[i];
            int bitmask = 0;
            for (char ch : w.toCharArray()) {
                bitmask |= 1 << bitNumber(ch);
            }
            map.put(bitmask, Math.max(map.getOrDefault(bitmask, 0), w.length()));
        }

        int maxProd = 0;
        for (int i:map.keySet()) {
            for (int j :map.keySet()) {
                if ((i & j) == 0) {
                    maxProd = Math.max(maxProd, map.get(i) * map.get(j));
                }
            }
        }
        return maxProd;
    }
}