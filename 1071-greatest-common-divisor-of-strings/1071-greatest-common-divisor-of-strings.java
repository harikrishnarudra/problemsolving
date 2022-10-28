class Solution {
    public String gcdOfStrings(String str1, String str2) {
        Set<Character> visitedChars = new HashSet<>();
        String subStr = str1.length() > str2.length() ? str2 : str1;
        int len = subStr.length();
        String maxSubString = "";
        if (len > 0 && replaceableString(subStr, str1) && replaceableString(subStr, str2)) {
            return subStr;
        }
        for(int j=0;j<len;j++){
            if (!visitedChars.contains(str1.charAt(j)) && str1.charAt(j) == str2.charAt(j)) {
                visitedChars.add(str1.charAt(j));
            } else {
                String subString = str1.substring(0, j);
                if (subString.length() > 0 && replaceableString(subString, str1) && replaceableString(subString, str2)) {
                    if (subString.length() > maxSubString.length()) {
                        maxSubString = subString;
                    }
                }
            }
        }
        return maxSubString;
    }

    private boolean replaceableString(String subStr, String givenString){
        int len = givenString.length();
        int subLen = subStr.length();
        if(len%subLen == 0){
            int n = len/subLen;
            StringBuilder stringBuilder = new StringBuilder();
            int k=0;
            while(k < n){
                stringBuilder.append(subStr);
                k++;
            }
            return stringBuilder.toString().equalsIgnoreCase(givenString);
        }
        return false;
    }
}