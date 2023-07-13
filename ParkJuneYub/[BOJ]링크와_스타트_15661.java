걸린 시간 : 70분
레벨 : 실버 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] map;
	public static int n, t;
	public static int scoreA;
	public static int scoreB;
	public static int result = Integer.MAX_VALUE;
	
	private static void checkScore(boolean[] teamA) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(teamA[i] && teamA[j]) {
					scoreA += map[i][j];
				}
				if(!teamA[i] && !teamA[j]) {
					scoreB += map[i][j]; 
				}
			}
		}
		if(Math.abs(scoreA-scoreB) <= result) {
			result = Math.abs(scoreA-scoreB);
		}
		scoreA = 0;
		scoreB = 0;
	}
	
	private static void makeTeam(int index, int start, boolean[] teamA) {
		// 설정된 팀원의 수 만큼 index 탐색, start는 이전 결과들을 중복되지 않고 넘길 수 있음 => 시간 단축
		if(index == t) {
			checkScore(teamA);
			if(result == 0) {
				System.out.println(result);
				System.exit(0);
			}
			return;
		}
		
		for(int i = start; i < teamA.length; i++) {
			if(!teamA[i]) {
				teamA[i] = true;
				makeTeam(index+1, i+1, teamA);
				teamA[i] = false;
			}
		}
		return;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		boolean[] teamA = new boolean[n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= n; i++) {
			t = i;
			makeTeam(0, 0, teamA);
		}
		System.out.print(result);
		
		
		
	}// end of main(String args[])  -----------------------------
}      
