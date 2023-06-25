import java.util.*;

class Solution {
	public static String[][] orderOperation = {
			"+-*".split(""),
			"+*-".split(""),
			"-+*".split(""),
			"-*+".split(""),
			"*+-".split(""),
			"*-+".split("")
	};
	
	public long calculation(long lnum, long rnum, String preOp) {
		long result = 0;
		switch(preOp) {
		case "+":
			result = lnum + rnum;
			break;
		case "-":
			result = lnum - rnum;
			break;
		case "*":
			result = lnum * rnum;
			break;
		}
		return result;
	}
	
	public long calculation(List<String> list, int operationNum) {
		for(String op : orderOperation[operationNum]) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(op)) {
					long lnum = Long.parseLong(list.get(i-1));
					long rnum = Long.parseLong(list.get(i+1));
					long result = calculation(lnum, rnum, op);
					list.remove(i-1);
					list.remove(i-1);
					list.remove(i-1);
					list.add(i-1, String.valueOf(result));
                    i -= 2;									 // 꼭 기억하자 index 부분을 다시 재정의해줘야 한다.
				}
			}
		}
		return Long.parseLong(list.get(0));
	}
	
    public long solution(String expression) {
		StringTokenizer tokens = new StringTokenizer(expression, "+-*", true);
		List<String> mathList = new ArrayList<>();
		
		while(tokens.hasMoreTokens()) {
			mathList.add(tokens.nextToken());
		}
		
		long max = 0;
		for(int i = 0; i < orderOperation.length; i++) {
			long result = Math.abs(calculation(new ArrayList<>(mathList), i));
			if(max < result) {
				max = result;
			}
		}
		return max;
    }
}