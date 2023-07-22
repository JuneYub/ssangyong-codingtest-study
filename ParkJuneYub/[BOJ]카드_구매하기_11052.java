걸린 시간 : 60분
레벨 : 실버 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n = 0;
	static Double[] arr;

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		int[] p = new int[10001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			for(int buyIdx = 1; buyIdx <= i; buyIdx++) {
				dp[i] = Math.max(dp[i], dp[i-buyIdx] + p[buyIdx]);
			}
		}
		
		System.out.println(dp[n]);
		
	}// end of main(String args[])  -----------------------------
}      
