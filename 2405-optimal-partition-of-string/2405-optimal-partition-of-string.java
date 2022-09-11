class Solution {
    public int partitionString(String s) {
        if(s.length()<=1){
            return 1;
        }
        int start = 0, result = 1;
        for(int i=1;i<s.length();i++){
            if(s.substring(start, i).contains(String.valueOf(s.charAt(i)))){
                result++;
                start=i;
            }
        }
        
        return result;
    }
}