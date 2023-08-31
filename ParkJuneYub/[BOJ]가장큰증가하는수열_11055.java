걸린 시간 : 90분
레벨 : 실버 2

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static long[] memo;
	static long[] 배열;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		배열 = new long[n+1];
		memo = new long[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++ ) {
			배열[i] = Integer.parseInt(st.nextToken());
		}
		
		memo[1] = 배열[1];
		for(int 현재값 = 2; 현재값 <= n; 현재값++) {
			
			for(int 이전값 = 1; 이전값 < 현재값; 이전값++) {
				if(배열[현재값] > 배열[이전값]) {
					memo[현재값] = Math.max(memo[이전값], memo[현재값]);
				}
			}
			memo[현재값] += 배열[현재값];
		}
		
		long result = 0;
		for(int i = 1; i <= n; i++) {
			result = Math.max(result, memo[i]);
		}
		System.out.println(result);
	}// end of main(String args[])  -----------------------------
}      
