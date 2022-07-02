class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<boxTypes.length; i++){
            map.put(i,boxTypes[i][1]);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for(Map.Entry<Integer, Integer> entry: list){
            int numBox = boxTypes[entry.getKey()][0];
            if(numBox <= truckSize){
                sum += numBox*entry.getValue();
                truckSize -= numBox;
            }else{
                sum += truckSize*entry.getValue();
                break;
            }
        }
        return sum;
    }
}