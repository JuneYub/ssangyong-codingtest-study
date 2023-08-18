걸린 시간 : 43분
레벨 : 실버 2

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n = 0;
	static long memo[] = new long[1000001];
	static int MOD = 1000000009;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 4; i <= 1000000; i++) {
			memo[i] = (memo[i-1] + memo[i-2] + memo[i-3] )% MOD;
		}
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(memo[num]).append('\n');
		}
		System.out.println(sb.toString());
	}// end of main(String args[])  -----------------------------
}      