class Solution {
    public int mostFrequentEven(int[] nums) {
        int max = -1;
        int maxEvenElement = -1;
        Map<Integer, Integer> map = new HashMap();

        for(int i:nums){
            if(i==0 || i%2==0){
                if(map.containsKey(i)){
                    map.put(i,map.get(i)+1);
                }else{
                    map.put(i, 1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()> max){
                max = entry.getValue();
                maxEvenElement = entry.getKey();
            }
            if(entry.getValue() == max){
               if(entry.getKey() < maxEvenElement)
                maxEvenElement = entry.getKey();
            }
        }
        return maxEvenElement;
        
    }
}