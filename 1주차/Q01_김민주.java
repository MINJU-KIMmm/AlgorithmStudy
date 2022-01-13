import java.util.*;
import java.io.*;
public class Q01_김민주 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 정렬 
		int cnt=0; // 그룹수(답)
		int person=0; // 각 그룹에 속한 사람 수 
		
		//모든 사람이 속하지 않아도 되기 때문에 그룹이 형성이 된다면 다음 그룹을 세면 된다.
		for(int i=0;i<N;i++) {
			person++; //arr[i] 사람이 그룹에 들어감 (그룹에 속한 사람 수 ++)
			//가장 최근에 들어간 사람이 그룹에 있는 사람들 중 공포심이 가장 높은 사람이므로 person이 arr[i] 이상이면 cnt 증가 
			//person은 다시 0으로 초기화(다음부턴 새로운 그룹으로 초기화)
			if(person>=arr[i]) {
				cnt++;
				person=0;
			}
		}
		
		System.out.println(cnt);
	}

}
