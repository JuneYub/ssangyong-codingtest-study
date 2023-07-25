걸린 시간 : 30분
레벨 : 실버 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int n = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		int[] p = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		// i개의 카드 개수를 채우기 위한 모험을 시작한다.
		for(int i = 1; i <= n; i++) {
			// i 가 한장이라면? 1 = dp[i] 안사서 i가 그대로 이거나 또는 dp[i-1] + p[1] 이다. 
			for(int j = 1; j <= i; j++) {
				// 왜 j는 i보다 작거나 같을까?  그 이유는 1장이라면 2장 못사고 사야할 게 2장이라면 2장까지만 탐색하기 때문이다.
				dp[i] = Math.min(dp[i], dp[i-j] + p[j]);
			}
		}
		System.out.println(dp[n]);
	}// end of main(String args[])  -----------------------------
}      
