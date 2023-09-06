걸린 시간 : 30분
레벨 : 실버 2

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[] = new int[1001];
	static int memo[] = new int[1001];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(memo, 1);
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			for( int j = 1; j < i; j++) {
				if(arr[j] > arr[i]) {
					memo[i] = Math.max(memo[j]+1, memo[i]);
					//System.out.println(i + "  " + memo[i]);
				}
			}
			max = Math.max(memo[i], max);
		}
		System.out.println(max);
		
		
		
	}// end of main(String args[])  -----------------------------
}      
