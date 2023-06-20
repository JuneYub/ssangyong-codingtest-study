import java.util.*;

class Solution {
    // split 메소드, 문자열과 길이를 받아 문자열을 일정한 길이로 쪼개줌 문자열 초과하면 그냥 문자열 끝까지 잘라서 쪼개줌 
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for(int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if(endIndex > source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }
        
    // compress 메소드 split 메소드로 문자열 쪼개서 압축처리함
    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();
        
        String last = "";
        int count = 0;
        for(String tokens: split(source, length)) {
            if(tokens.equals(last)) {
                count++;
            }
            else {
                if(count > 1) {
                    builder.append(count);
                }
                builder.append(last);
                last = tokens;
                count = 1;
            }
        }
        if(count > 1) {
            builder.append(count);
        }
        builder.append(last);
        return builder.length();
    }
    
    // 메인 메소드
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if(compressed < min) {
                min = compressed;
            }
        }
        return min;
    }
}