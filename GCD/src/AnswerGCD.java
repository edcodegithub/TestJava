import java.util.Arrays;


public class AnswerGCD {
	public static int gcd(int a,int b){
		if(a<b){
			int temp=a;
			a=b;
			b=temp;
			
		}
		if(b==0){
			return a;
		}
		return	gcd(b,a%b);
		
	}
	public static int gcd1(int[] arr){
		if(arr.length==1){
			return arr[0];
		}
		
		int ans=arr[0];
		for(int i= 1;i<arr.length;i++){	
			if(ans<arr[i]){
				int temp=ans;
				ans=arr[i];
				ans=temp;
				
			}
			int b= arr[i];
			while(b!=0){				
				int r=ans%b;
				ans=b;
				b=r;
			}
			 
		}
		return ans;
	}
	
	
	public static void main(String[] args){
		int a=61;
		int b=18;
		int[] arr={70};
		System.out.println(gcd1(arr));
		
	}

}
