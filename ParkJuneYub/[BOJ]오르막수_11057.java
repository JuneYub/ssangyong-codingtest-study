걸린 시간 : 27분
레벨 : 실버 1

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n = 0;
	static int mod = 10007;
	static long memo[][] = new long[1001][10];

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i <= 9; i++) {
			memo[1][i] = 1;
		}
		if(n != 1) {
			for(int i = 2; i <= n; i++) {
				for(int j = 0; j <= 9; j++) {
					for(int k = 0; k <= j; k++) {
						if(k <= j) {
							memo[i][j] += (memo[i-1][k])%mod; 
							//System.out.println("j :" + j + " k : " + k + " " +memo[i][j]);
						}
					}
				}
			}
		}
		int result = 0;
		for(int i = 0; i <= 9; i++) {
			result += memo[n][i];
		}
		
		System.out.println((result)%mod);
	}// end of main(String args[])  -----------------------------
}      
