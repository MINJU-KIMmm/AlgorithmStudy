package Ch2_Implementation;

import java.io.*;
import java.util.*;
public class Q08_김민주 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String S=br.readLine();
		
		int sum=0; //숫자 더한 값을 담을 변수 
		ArrayList<Character> arr=new ArrayList<>(); //문자열 중 알파벳을 담을 리스트 
		
		for(int i=0;i<S.length();i++) {
			char c=S.charAt(i);
			if(c>='0'&&c<='9')sum+=c-'0'; //숫자인 경우 sum에 값 더함 
			else arr.add(c); //알파벳인 경우 배열에 추가 
		}
		
		Collections.sort(arr); // 알파벳 배열 정렬 
		
		StringBuilder sb=new StringBuilder(); //출력값을 이어붙임 
		for(int i=0;i<arr.size();i++) {
			sb.append(arr.get(i)); //알파벳 먼저 이어 붙임 
		}
		
		sb.append(sum); // 마지막에 숫자 이어 붙임 
		
		System.out.println(sb);
	}

}
