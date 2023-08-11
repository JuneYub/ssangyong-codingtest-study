걸린 시간 : 50분
레벨 : 실버 2


import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n = 0;
	static int memo[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		memo = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			memo[i] = Math.max(memo[i-1]+arr[i], arr[i]);
		}
		
		int maxResult = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			maxResult = Math.max(maxResult, memo[i]);
		}
		System.out.println(maxResult);
		
	}// end of main(String args[])  -----------------------------
}      