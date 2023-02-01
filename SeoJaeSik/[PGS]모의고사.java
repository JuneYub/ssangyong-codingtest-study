import java.util.ArrayList;
import java.util.List;

public class ex_3 {
	
	class Solution {
	    public int[] solution(int[] answers) {
	        int[] answer = {};
	        
	        int [] a = {1,2,3,4,5}; // 1번 수포자
	        int [] b = {2,1,2,3,2,4,2,5}; // 2번 수포자
	        int [] c = {3,3,1,1,2,2,4,4,5,5}; // 3번 수포자
	    
	        int a1 = 0, b1 = 0, c1 = 0; // 맞춘 개수 카운트
	        
	        for (int i=0; i<answers.length; i++) {
	        	if (a[i%5] == answers[i]) { 
	        		a1++; // 5씩 반복한 값이 정답이면 ++
	        	}
	        	if (b[i%8] == answers[i]) {
	        		b1++; // 8씩 반복한 값이 정답이면 ++
	        	}
	        	if (c[i%10] == answers[i]) {
	        		c1++; // 10씩 반복한 값이 정답이면 ++
	        	}
	        }
	        
	        int max = Math.max(a1, (Math.max(b1, c1)) );
	        
	        List<Integer> list = new ArrayList<>(); 
	        // 출력할 값을 추가할 list 생성
	        
	        if (max == a1) {
	        	list.add(1);
	        }
	        if (max == b1) {
	        	list.add(2);
	        }
	        if (max == c1) {
	        	list.add(3);
	        }
	        
	        answer = new int [list.size()];
	        
	        for (int i=0; i<list.size(); i++) {
	        	answer[i]=list.get(i);
	        }  // 최대 개수로 맞춘사람들 list에 번호를 뽑아 출력
	        
	        return answer;
	    }
	}

	public static void main(String[] args) {
		
		
	}

}
