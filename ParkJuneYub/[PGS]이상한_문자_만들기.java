class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        
        for(char c:s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                builder.append(c);
                toUpper = true;
            }
            else {
                if(toUpper) {
                    builder.append(Character.toUpperCase(c));
                    toUpper = false;
                }
                else {
                    builder.append(Character.toLowerCase(c));
                    toUpper = true;
                }
            }
        }
        return builder.toString();
    }
}