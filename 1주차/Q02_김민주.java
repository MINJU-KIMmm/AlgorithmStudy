import java.util.*;
import java.io.*;
//1이 될때까지와 비슷한 문제 
public class Q02_김민주 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); //입력
		
		//a값 초기화. 이 값에 계속해서 연산해 나갈것임 
		int a=str.charAt(0)-'0';
		
		for(int i=1;i<str.length();i++) {
			int b=str.charAt(i)-'0';
			
			//a나 b가 0또는 1인 경우엔 덧셈
			if(a==0||a==1||b==0||b==1) {
				a+=b;
			}
			//2이상인 경우엔 곱셈 
			else {
				a*=b;
			}
		}
		
		System.out.println(a);
	}

}
