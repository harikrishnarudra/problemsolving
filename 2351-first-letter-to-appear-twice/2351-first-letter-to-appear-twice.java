class Solution {
    public char repeatedCharacter(String s) {
        char result = '&';
        int[] arr = new int[26];
        for(char c:s.toCharArray()){
            if(arr[c-'a'] == 1){
                result=c;
                break;
            }
            arr[c-'a'] += 1; 
        }
        return result;        
    }
}