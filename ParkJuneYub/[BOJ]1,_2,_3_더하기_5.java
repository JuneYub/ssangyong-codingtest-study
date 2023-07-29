걸린 시간 : 40분
레벨 : 실버 2

import java.io.*;

public class Main {
	static int n = 0;
	static long[][] dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			for(int j = 4; j <= num; j++) {
				dp[j][1] = (dp[j-1][2] + dp[j-1][3])%1000000009;
				dp[j][2] = (dp[j-2][1] + dp[j-2][3])%1000000009;
				dp[j][3] = (dp[j-3][1] + dp[j-3][2])%1000000009;
			}
			sb.append((dp[num][1] + dp[num][2] + dp[num][3])%1000000009).append("\n");
		}
		System.out.println(sb);
		
	}// end of main(String args[])  -----------------------------
}      
