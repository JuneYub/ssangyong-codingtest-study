package my.Myutil;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n = 0;
	static int mod = 9901;
	static long memo[][] = new long[100001][3];

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		memo[0][2] = 1;
		
		for(int i = 1; i <= n; i++) {
			memo[i][0] = (memo[i-1][1] + memo[i-1][2])%mod;
			memo[i][1] = (memo[i-1][0] + memo[i-1][2])%mod;
			memo[i][2] = (memo[i-1][0] + memo[i-1][1] + memo[i-1][2])%mod;
		}
		
		System.out.println((memo[n][0]+memo[n][1]+memo[n][2])%mod);
	}// end of main(String args[])  -----------------------------
}      
