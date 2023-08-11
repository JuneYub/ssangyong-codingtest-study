걸린 시간 : 30분
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
		memo = new int[n];
		Arrays.fill(memo, 1);
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(arr[i] > arr[j]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}
		int result = 0;
		for(int i = 0; i < n; i++) {
			result = Math.max(result, memo[i]);
		}
		System.out.println(result);
	}// end of main(String args[])  -----------------------------
}      
