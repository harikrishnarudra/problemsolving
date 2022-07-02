class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int sum = 0;
        int[] boxesvsunits = new int[1001];
        for(int[] boxType:boxTypes){
            boxesvsunits[boxType[1]] += boxType[0];
        }
        for(int i=boxesvsunits.length-1; i>0; i--){
            if(boxesvsunits[i] > 0){
                if(boxesvsunits[i] <= truckSize){
                    sum +=  boxesvsunits[i]*i;
                    truckSize -= boxesvsunits[i];
                }else{
                    sum += i * truckSize;
                    break;
                }
            }
        }
        return sum;
    }
}