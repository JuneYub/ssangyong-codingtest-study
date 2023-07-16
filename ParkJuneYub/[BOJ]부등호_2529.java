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
	public static int n;
	public static long min = Long.MAX_VALUE;
	public static long max = Long.MIN_VALUE;
	public static String minStr = "1";
	public static String maxStr = "1";
	public static List<String> result = new ArrayList<>();
	
	
	// a와 b를 부등호와 함께 비교하고 통과하면 b를 배열에 집어넣는다
	public static boolean compareAB(int a, int b, String sign) {
		if(sign.equals(">")) return a>b;
		else return a<b;
	}
	
	// 재귀함수(depth, result, visited[])
	public static void recursive(int depth, String str, boolean visited[], String[] signs) {
		if(depth == n+1) {
			result.add(str);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(depth == 0 || !visited[i] && compareAB(str.charAt(str.length() - 1) - '0' , i, signs[depth-1])) {
				visited[i] = true; 
				recursive(depth+1, str + i, visited, signs);
				visited[i] = false;
			}
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] signs = new String[n];
		boolean[] visited = new boolean[10];
		
		signs = br.readLine().split(" ");
		recursive(0, "", visited, signs);
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(result.get(result.size()-1)).append("\n").append(result.get(0));
		System.out.println(sb.toString());
	}// end of main(String args[])  -----------------------------
}      
