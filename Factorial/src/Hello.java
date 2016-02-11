
public class Hello {
	public static int method(int a,int b){
		int x=0;
		int y=0;
		int ans=1;
		while(ans<=b){
			if(y<=a){				
				y++;
				x++;
				ans=ans*y;
			}
			else if(y>a && x<=b ){				
				//y++;				
				x++;
				ans=ans*x;
			}
		}
		return x-y+1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		int val1=0;
		int val2=0;
		System.out.println(method(val1,val2));
		

	}

}
