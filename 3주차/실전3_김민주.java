package Ch3_DfsBfs;

import java.util.*;
import java.io.*;
public class 실전_음료수얼려먹기_김민주 {
	
	static int[][] arr;
	static int N, M;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//-------입력 시작----------
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		visited=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		//--------입력 끝 --------------
		
		//======bfs========
		int count=0; //정답을 담을 변수 
		//탐색시작 - bfs
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0&&!visited[i][j]) {
					bfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		//==================
		
		//=======dfs=========
		count=0;
		visited=new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0&&!visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		//====================
		
		//=====답지풀이dfs========
		count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(dfs_answer(i,j)) count++;
			}
		}
		
		System.out.println(count);
		//======================
	}
	
	
	//bfs 
	static void bfs(int x, int y) {
		Queue<IceCream>q=new LinkedList<>();
		
		q.offer(new IceCream(x, y));//큐에 삽
		visited[x][y]=true; //방문 체크 
		
		while(!q.isEmpty()) {
			IceCream ice=q.poll();
			int cx=ice.x;
			int cy=ice.y;
			
			for(int i=0;i<4;i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				
				if(arr[nx][ny]==0&&!visited[nx][ny]) {
					q.offer(new IceCream(nx,ny));
					visited[nx][ny]=true;
				}
			}
		}
	}
	
	//dfs
	static void dfs(int x, int y) {
		visited[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			
			if(!visited[nx][ny]&&arr[nx][ny]==0) dfs(nx, ny);
		}
	}
	
	//dfs-답지 
	static boolean dfs_answer(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) return false;
		
		if(arr[x][y]==0) {
			arr[x][y]=1;
			
			dfs_answer(x-1, y);
			dfs_answer(x, y-1);
			dfs_answer(x+1, y);
			dfs_answer(x, y+1);
			
			return true;
		}
		
		return false;
	}
}

class IceCream{
	int x;
	int y;
	
	public IceCream(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
