import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SriNatg {
	static int search(List<Integer>a,int b){
		int start=0;
		int end=a.size()-1;
		int result=-1;
		int index=-1;
		if(b<a.get(0)){
			return start;
		}
		else if(b>a.get(end)){
			return end+1;
		}
		while(start<=end){
			index=start+((end-start)/2);
			if(a.get(index)==b){
				result=index;
				end=index-1;
			}
			else if(a.get(index)>b){
				end=index-1;
			}
			else{
				start=index+1;
			}
		}
		//System.out.println("res= "+result);
		if(result==-1){
			//System.out.println("alam"+end);
			return end+1;
		}
		return result;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Integer> ip = new ArrayList<>();
		while(sc.hasNextInt()){
			ip.add(sc.nextInt());
		}
		//System.out.println(ip.size());
		System.out.println(search(ip,8));
		sc.close();//tr
		// TODO Auto-generated method stub
		

	}

}
