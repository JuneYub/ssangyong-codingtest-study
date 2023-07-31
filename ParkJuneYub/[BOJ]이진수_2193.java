걸린 시간 : 20분
레벨 : 실버 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n = 0;
	static long dp[][];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[91][2];
		dp[1][1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}

		System.out.println((dp[n][0] + dp[n][1]));

		
	}// end of main(String args[])  -----------------------------
}      
