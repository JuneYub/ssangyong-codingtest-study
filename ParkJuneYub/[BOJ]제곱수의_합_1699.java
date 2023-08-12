걸린 시간 : 70분
레벨 : 실버 2

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n = 0;
	static int memo[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		memo = new int[n+1];
		
		// 초기에는 모든 값이 1^2 + 1^2 ... 의 합으로 구해져 있다고 생각한다. 최소항을 구하는 것이므로
		for(int i = 1; i <= n; i++) {
			memo[i] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j*j <= i; j++) {
				// 36-1^2 36-2^2
				memo[i] = Math.min(memo[i], memo[i - j*j]+1);
			}
		}
		System.out.println(memo[n]);
	}// end of main(String args[])  -----------------------------
}      
