class Solution {
    public boolean removeOnes(int[][] grid) {
        int[] first = grid[0];
        int[] r_first = Arrays.stream(first).map(i -> 1-i).toArray();
        for(int i=1;i<grid.length;i++){
            if(!areBothSame(first,grid[i]) && !areBothSame(r_first, grid[i])){
                return false;
            }
        }
        return true;
    }
    private boolean areBothSame(int[] f, int[] s){
        for(int i=0;i<f.length; i++){
            if(f[i]!=s[i]){
                return false;
            }
        }
        return true;
    }
}