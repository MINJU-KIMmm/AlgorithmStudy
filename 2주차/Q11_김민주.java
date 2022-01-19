package Ch2_Implementation;

import java.util.*;
import java.io.*;

public class Q11_김민주 {
	static int[] dx= {0, 1, 0, -1}; //방향 이동위함 right, down, left, up(인덱스가 커질수록 오른쪽으로 90도 회전) 
	static int[] dy= {1, 0, -1, 0};
	static int N;
	static ArrayList<position> snake=new ArrayList<>(); //뱀의 위치 담음, 꼬리가 0에 있음 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//---------입력시작------------- 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[N][N];
		
		for(int i=0;i<K;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[x-1][y-1]=1;
			
		}
		
		int L=Integer.parseInt(br.readLine());
		Map<Integer, String> rotate=new HashMap<>(); //회전시각과 회전 방향 HashMap으로 받음 
		for(int i=0;i<L;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int time=Integer.parseInt(st.nextToken());
			String turn=st.nextToken();
			
			rotate.put(time, turn);
		}
		
		//---------입력 끝---------
		
		int time=0; //걸린 시간(답)
		int dir=0; //방향 인덱스(dx, dy의 인덱스) 
		int x=0; //현재 위치(행)
		int y=0; //현재 위치(열)
		

		snake.add(new position(0,0)); //시작 위치 0,0 snake에 추가 
		
		while(true) {
			time++; //시간 증가
			//다음 위치 계산 
			int nx=x+dx[dir];
			int ny=y+dy[dir];
			
			//게임 끝났는지 판별 
			if(check(nx, ny)) break;
			
			//사과 있는 경우 
			if(arr[nx][ny]==1) {
				arr[nx][ny]=0; //뱀이 지나가면 사과 없어짐 
				snake.add(new position(nx, ny));
			}
			//사과 없는 경우 
			else {
				snake.add(new position(nx, ny)); //snake에 새로운 위치추가 
				snake.remove(0); //꼬리제거 
			}
			
			//위치 업데이트 
			x=nx;
			y=ny;
			
			//rotate에 있는 시간과 time이 일치하면 회전 
			if(rotate.containsKey(time)) {
				String d=rotate.get(time);
				dir=rotateDir(dir, d);
				
			}
		}
		
		System.out.println(time);
	}
	
	//방향 회전 
	static int rotateDir(int cur, String dir) {
		int next=cur;
		//오른쪽 
		if(dir.equals("D")) {
			next+=1;
			if(next>=4) {
				next=0;
			}
		}
		//왼쪽 
		else {
			next-=1;
			if(next<0) {
				next=3;
			}
		}
		
		return next;
	}
	
	//게임 체크 
	static boolean check(int x, int y) {
		//범위 밖이면 (벽과 부딪히면)
		if(x<0||x>=N||y<0||y>=N) return true;
		
		//자기 몸통과 부딪히면 
		for(int i=0;i<snake.size();i++) {
			//뱀이 있는 위치를 모두 탐색하며 현재 위치와 뱀이 있던 위치가 같으면 종료 
			position p=snake.get(i);
			if(p.x==x&&p.y==y) return true;
		}
		
		return false;
	}

}

//뱀 위치 나타내는 클래스 
class position{
	int x;
	int y;
	
	public position(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
