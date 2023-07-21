걸린 시간 : 130분
레벨 : 골드 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[][] map;
	public static boolean[][] visited;
	public static int result;
	
	public static int sum() {
		int total = 0;
		int sum = 0;
		
		for(int row = 0; row < n; row++) {
			sum = 0;
			for(int col = 0; col < m; col++) {
				if(visited[row][col]) {
					sum = (sum*10)+map[row][col];
				} else {
					total += sum;
				}
			}
			total += sum; // 가로 한 줄이 쭉 연결되는 경우도 있으니
		}
		
		for(int col = 0; col < n; col++) {
			sum = 0;
			for(int row = 0; row < m; row++) {
				if(!visited[row][col]) {
					sum = (sum*10)+map[row][col];
				} else {
					total += sum;
				}
			}
			total += sum; // 가로 한 줄이 쭉 연결되는 경우도 있으니
		}
		
		return total;
	}
	
	public static void dfs(int x, int y) {
		if(x == n) {
			//System.out.println("합계 : " + sum());
			result = Math.max(result, sum());
			return;
		}
		
		if(y == m) {
			dfs(x+1, 0);
			return;
		}
		
		visited[x][y] = true;
		dfs(x, y+1);
		visited[x][y] = false;
		dfs(x, y+1);
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		dfs(0,0);
		System.out.println(result);
		
	}// end of main(String args[])  -----------------------------
}      
