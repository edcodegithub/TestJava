import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ans1 {
	static int search(List<Integer>a,int b){
		int start=0;
		int end=a.size()-1;
		int result=-1;
		if(b<a.get(0)){
			return start;
		}
		else if(b>a.get(end)){
			return end;
		}
		while(start<=end){
			int index=start+((end-start)/2);
			if(a.get(index)==b){
				result=index;
				end=index-1;
			}
			else if(a.get(index)>b){
				end=index-1;
			}
			else{
				start=end+1;
			}
		}
		if(result==-1){
			return end+1;
		}else{
			return result;
		}
	}
	
	public static void manin(String[] args){
		Scanner sc=new Scanner(System.in);
		List<Integer> ip = new ArrayList<>();
		while(sc.hasNextInt()){
			ip.add(sc.nextInt());
		}
		search(ip,5);
		sc.close();//tr
	}


}
