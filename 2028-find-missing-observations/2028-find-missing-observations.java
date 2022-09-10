class Solution {
    public int[] missingRolls(int[] A, int mean, int F) {
        int sum = 0, N=A.length;
        for(int i:A){
            sum += i;
        }
        int remaining = mean*(N+F)-sum;
        if(remaining > F*6 || remaining<0 || remaining < F ){
            return new int[0];
        }
        int[] result = new int[F];
        Arrays.fill(result, 1);
        remaining -= F;
        for(int i=0;i<F;i++){
            int canAddVal = Math.min(remaining, 5);
            remaining -= canAddVal;
            result[i] += canAddVal;
            if(remaining==0){
                break;
            }
        }
        return result;
    }
}