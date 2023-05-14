
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
/*
 필요변수
 노드 개수
 간선 개수
 ArrayList 의 그래프
 불린 배열 비지티드
 큐<인티저> 뉴 링크드리스트
 
 필묘 메소드
 BFS()
 큐가 비어있지 않다면
 현재 노드는 q에서 가져오고 (poll)
 
 그래프에서 현재 노드에 해당하는 리스트의 크기 만큼 반복한다.
 다음 노드는 현재 노드의 리스트에서 순차적으로 가져오고
 만약 방문하지 않았떤 거라면 방문하고 큐에 추가한다.
 
 메인 함수
 간선과 노드의 개수 설정해주고
 그래프는 간선개수+1 만큼 어레이 리스트 배열로 구성한다.
 비지티드도 간선개수+1 만큼 배열로 만든다.
 
 1부터 간선 개수만큼 그래프[i]에게 새로운 arrayList를 주고
 
 스타트Points[] endPoints[] 간선 개수만큼 배열 설정하고
 0부터 간선 개수만큼 스타트Points[] endPoints[] 에 간선 연결해준다.
 
 이를 이용해 그래프.add 를 활용해 그래프의 노드를 이어준다. <= 링크드 리스트에 추가하는 거임
 
 rootVertex = 1 큐에 추가하고 비지티드 하고 
 BFS 실행
*/


public class Main {
	
	public static int VERTICES_NUM;
	public static int EDGES_NUM;
	
	public static ArrayList<Integer>[] graph; 
	public static boolean[] visited;
	public static Queue<Integer> q = new LinkedList<>();
	
	public static void BFS() {
		while(!q.isEmpty()) {
			int currV = q.poll();
			
			for(int i = 0; i < graph[currV].size(); i++) {
				int nextV = graph[currV].get(i);
				if(!visited[nextV]) {
					visited[nextV] = true;
					q.add(nextV);
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		VERTICES_NUM = Integer.parseInt(br.readLine());
		EDGES_NUM = Integer.parseInt(br.readLine());
		graph = new ArrayList[VERTICES_NUM+1];
		for(int i = 1; i <= VERTICES_NUM; i++) {
			graph[i] = new ArrayList<>();
		}
		
		visited = new boolean[VERTICES_NUM + 1];
		
		int[] startPoints = new int[EDGES_NUM];
		int[] endPoints = new int[EDGES_NUM];
		
		
		
		for(int i = 0; i < EDGES_NUM; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			startPoints[i] = Integer.parseInt(st.nextToken());
			endPoints[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i = 0; i < EDGES_NUM; i++) {
			int start = startPoints[i];
			int end = endPoints[i];
			
			graph[start].add(end);
			graph[end].add(start);
		}
		
		int rootVertex = 1;
		visited[rootVertex] = true;
		q.add(rootVertex);
		BFS();
		
		int cnt = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == true) {
				cnt++;
			}
		}
		
		System.out.println(cnt-1);
		
		
		
		
		
	}// end of main(String args[])  -----------------------------
		
	
}      


