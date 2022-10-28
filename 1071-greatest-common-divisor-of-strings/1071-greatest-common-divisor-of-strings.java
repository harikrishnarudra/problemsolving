class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int s1Leng = str1.length();
        int s2Leng = str2.length();
        Set<Character> visitedChars = new HashSet<>();
        String subStr = s1Leng > s2Leng ? str2 : str1;
        int len = subStr.length();
        String maxSubString = "";
        int i = 0;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        if (subStr.length() > 0 && replaceableString(subStr, str1) && replaceableString(subStr, str2)) {
            return subStr;
        }

        for(int j=0;j<len;j++){
            if (!visitedChars.contains(s1[j]) && s1[j] == s2[j]) {
                visitedChars.add(s1[j]);
            } else {
                String subString = str1.substring(i, j - i);
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