걸린 시간 : 30분
레벨 : 실버 1

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n = 0;
	static long dp[][] = new long[1001][3];
	static long memo[][] = new long[1001][3];

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 3; c++) {
				dp[i][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= n; i++) {
			memo[i][0] = dp[i][0] + Math.min(memo[i-1][1], memo[i-1][2]); 
			memo[i][1] = dp[i][1] + Math.min(memo[i-1][0], memo[i-1][2]);
			memo[i][2] = dp[i][2] + Math.min(memo[i-1][0], memo[i-1][1]); 
		}
		
		System.out.println(Math.min(memo[n][0], Math.min(memo[n][1], memo[n][2])));
	}// end of main(String args[])  -----------------------------
}      