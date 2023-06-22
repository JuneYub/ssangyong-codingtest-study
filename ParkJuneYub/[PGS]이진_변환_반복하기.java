class Solution {
    public int countZeros(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') count++;
        }
        return count;
    }
    
    public int[] solution(String s) {
        int loopes = 0;
        int removedZeros = 0;
        
        while(!s.equals("1")) {
            // 0의 개수를 알아오는 메소드
            int zeroCnt = countZeros(s);
            
            loopes += 1;
            removedZeros += zeroCnt;
            
            // 0의 개수를 알면 1의 개수도 알 수 있다.
            int oneLength = s.length() - zeroCnt;
            s = Integer.toString(oneLength, 2);
        }
        return new int[] {loopes, removedZeros};
    }
}