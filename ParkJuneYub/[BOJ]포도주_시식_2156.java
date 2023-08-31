걸린 시간 : 90분
레벨 : 실버 1

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static long[] memo = new long[10001];
	static long[] dp = new long[10001];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.parseInt(br.readLine());
		}
		memo[1] = dp[1];
		memo[2] = memo[1] + dp[2];
		for(int i = 3; i<= n; i++) {
					
			long val = Math.max((memo[i-3] + dp[i-1] + dp[i]), (memo[i-2] + dp[i]));
			memo[i] = Math.max(val, memo[i-1]);
			//System.out.println("memo[i] : " + memo[i]);
		}
		
		System.out.println(memo[n]);
	}// end of main(String args[])  -----------------------------
}      