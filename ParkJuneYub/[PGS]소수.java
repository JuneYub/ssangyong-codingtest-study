package my.Myutil;

import java.util.*;

class Solution {
	
	// 접근방법
	// 중복되는 부분을 알아서 없애기 위해서 HashSet을 활용한다.
	// 숫자카드로 숫자(acc)를 만들어서 소수라면 위에서 만든 set에 포함시킨다.
	// 결국 이 문제는 모든 숫자카드 조합을 통해서 만드는 순열문제이다.
	// 순열문제는 다음과 같은 방식으로 접근한다 (재귀형식이며 현 상태조건 acc, numbers, boolen배열, 조건성립시 추가할 list)
	// 술열 메소드는 다음과 같은 형식이다. (종료조건, 종료조건이 아니라면 numbers만큼 돌 for문 boolean배열 체크 후 다시
	// 순열 메소드에 들어갈 준비
	
	private boolean isPrime(int num) {
		if(num <= 1) return false;
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	// acc => 현재 숫자카드로 만들어진 숫자, numbers => 남은 숫자카드, primes => 만들어진 소수들
	private void getPrime(int acc, List<Integer> numbers, boolean[] isUsed, Set<Integer> primes) {
		if(isPrime(acc)) primes.add(acc);
		
		for(int i = 0; i < numbers.size(); i++) {
			if(isUsed[i]) continue;
			int nextAcc = acc*10+numbers.get(i);
			List<Integer> nextNumbers = new ArrayList<>(numbers);
			isUsed[i] = true;
			getPrime(nextAcc, nextNumbers, isUsed, primes);
			isUsed[i] = false;
		}
	}
	
    public int solution(String numbers) {
    	boolean[] isUsed = new boolean[numbers.length()];
    	Set<Integer> primes = new HashSet<>();
    	List<Integer> list = new ArrayList<>();
    	for(int i = 0; i < numbers.length(); i++) {
    		list.add(Character.getNumericValue(numbers.charAt(i)));
    	}
    	getPrime(0, list, isUsed, primes);
		return primes.size();
    }
}