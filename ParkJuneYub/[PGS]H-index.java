import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        int hIndex = 0;
        for(int i = n; i > 0; i--) {
        	if(citations[n-i] >= i) {
        		hIndex = i;
                break;
        	}
        }
        return hIndex;
    }
}