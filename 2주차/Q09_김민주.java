package Ch2_Implementation;
import java.io.*;
import java.util.*;
public class Q09_김민주 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		System.out.println(solution(str));
	}

	static int solution(String s) {
        int answer = 0;
        ArrayList<Integer> lens=new ArrayList<>();
        
        if(s.length()==1) return 1; //문자열 한 글자인 경우 처리 안해주면 테스트 5에서 런타임 오류 남.
        for(int i=1;i<=s.length()/2;i++) {        	
        	int count=1; //반복 횟수 
        	String current=s.substring(0,i); //현재 기준이 되는 문자열 
        	StringBuilder sb=new StringBuilder(); //압축된 문자열을 쌓을 StringBuilder
        	
        	for(int j=i;j<=s.length();j+=i) {
        		String next=""; //다음 문자열(현재 문자열과 같은지 확인)
        		
        		//j+i(현재 위치 + 문자열 자른 길이)가 문자열의 길이를 초과한다면 문자열끝까지만 자름  
        		if(j+i>s.length()) {
        			next=s.substring(j, s.length());
        		}
        		//초과하지 않는다면 j+i까지 자름 
        		else {
        			next=s.substring(j, j+i);
        		}
        		
        		//같으면 count 증가 
        		if(current.equals(next)) count++;
        		//다르면 압축된 문자열 쌓고 current에 next 대입하고 count 초기화 해서 다음 탐색 진행 
        		else {
        			if(count!=1) sb.append(count);
        			sb.append(current);
        			current=next;
        			count=1;
        		}
        	}
        	
        	//마지막 남은 문자를 붙임 
        	sb.append(current);
        	//길이 배열에 압축된 문자열 길이 담기 
        	lens.add(sb.toString().length());
        }
        
       //정렬 
        Collections.sort(lens);
        //가장작은 수 return 
        answer=lens.get(0);
        return answer;
    }

}
