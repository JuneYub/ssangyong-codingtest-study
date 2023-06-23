import java.util.*;

class Solution {
    private static final char[] chars = "AEIOU".toCharArray();
    
    public List<String> generate(String word, List<String> words) {
        // generate 메소드를 거치는 모든 word는 단어장에 기록한다.
        words.add(word);
        
        // 만약 글자수가 5자라면 더 이상 진행하지 않는다.
        if(word.length() == 5) {
            return words;
        }
        
        // aeiou를 모두 한번씩 다 추가하면서 단어를 생성한다.
        for(char c: chars) {
            generate(word+c, words);
        }
        return words;
    }
    
    public int solution(String word) {
        List <String> words = new ArrayList<>();
        generate("", words);
        
        return words.indexOf(word);
    }
}