class Solution {
    public boolean removeOnes(int[][] grid) {
        int[] first = grid[0];
        for(int i=1;i<grid.length;i++){
            if(!isValid(first,grid[i] )){
                return false;
            }
        }
        return true;
    }
    private boolean isValid(int[] first, int[] current) {
        int result = 0;
        for (int i = 0; i < first.length; i++) {
            result += first[i] ^ current[i];
        }
        if (result == 0 || result == first.length)
            return true;
        else
            return false;
    }
}