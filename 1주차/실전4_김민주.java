import java.util.*;
import java.io.*;
public class 실전4_김민주 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int cnt=0;
		while(N!=1) {
			if(N%K==0) {
				cnt++;
				N/=K;
			}
			else {
				cnt++;
				N-=1;
			}
		}
		
		System.out.println(cnt);
	}

}
