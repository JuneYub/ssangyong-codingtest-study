걸린 시간 : 30분
레벨 : 실버 1

import java.io.*;

public class Main {
	
	static int n = 0;
	static long dp[][];
	static long MOD = 1000000000;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new long[101][10];
		
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][1]) % MOD;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
			dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % MOD;
			dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % MOD;
			dp[i][4] = (dp[i-1][3] + dp[i-1][5]) % MOD;
			dp[i][5] = (dp[i-1][4] + dp[i-1][6]) % MOD;
			dp[i][6] = (dp[i-1][5] + dp[i-1][7]) % MOD;
			dp[i][7] = (dp[i-1][6] + dp[i-1][8]) % MOD;
			dp[i][8] = (dp[i-1][7] + dp[i-1][9]) % MOD;
			dp[i][9] = dp[i-1][8] % MOD;
		}
		
		long result = 0;
		for(int i = 0; i <= 9; i++) {
			result += dp[n][i];
		}
		System.out.println(result % MOD);

		
	}// end of main(String args[])  -----------------------------
}      
