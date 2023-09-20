
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[] = new int[100001];
	static int[][] memo = new int[100001][2];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		memo[0][0] = memo[0][1] = arr[0];
		int result = arr[0];
		for(int i = 1; i < n; i++) {
			memo[i][0] = Math.max(arr[i], memo[i-1][0] + arr[i]);
			memo[i][1] = Math.max(memo[i-1][0], memo[i-1][1] + arr[i]);
			result = Math.max(result, Math.max(memo[i][0], memo[i][1]));
		}
		
		System.out.println(result);

	}// end of main(String args[])  -----------------------------
}      
