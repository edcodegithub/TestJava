
public class Sol {
	public static int method(int a,int b){
		int x=0;
		int y=0;
		int ans=1;
		while(x<=b){
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
	public void main(String[] args){
		int val1=2;
		int val2=122;
		System.out.println(method(val1,val2));
		
	}

}
