package com.Level2.Intro_Math.Examples;



/**
 * Decimal to Binary Conversion
 * @author srinath
 *
 */

public class Solution {
	public boolean isPower(int a) {
        //int temp=a;
        if(a==1){
            return true;
        }
        if(a==2){
            return false;
        }
        int limit=(int)Math.ceil((float)Math.sqrt(a));
        int temp=a;
        //System.out.println(limit);
        for(int i=2;i<=limit;i++){
            int set=0;
            int rem=0;
            a=temp;
            while(a>1){
                rem=a%i;
                if(rem>0){
                    set=1;
                    break;
                }
                a=a/i;
            }
            if(set==0){            	
                return true;
            }
        }
        
        return false;
    }
	public int reverse(int x) {
		//flag marks if x is negative
		boolean flag = false;
		if (x < 0) {
			x = 0 - x;
			flag = true;
		
		}
	 
		int res = 0;
		int p = x;
	    int c=0;
	    int check=0;
		while (p > 0) {
			int mod = p % 10;
			if(c==0){
				check=mod;
			}
			p = p / 10;
			res = res * 10 + mod;
			c++;		
		}
		if(check!=(int)(res/Math.pow(10, c-1))){
			return 0;
			
		}
	 
		if (flag) {
			res = 0 - res;
		}
	 
		return res;
	}
	
	public String findDigitsInBinary(int a) {
		if(a==0){
			return "0";
		}
		String ans="";
		if(a/2==0){
			return "1";
		}else{
			//System.out.println(a%2);
			ans=findDigitsInBinary(a/2)+(a%2);
			
		}
		return ans;
	}
	public String convertToTitle(int a) {
	    StringBuilder ans1=new StringBuilder();
	    a=a;
	    while(a>0){
	        int val=(a%26)-1+(int)'A';
	        char c=(char)val;
	        ans1.append(c);
	        a=a/26;    
	    }
	    ans1.reverse();
	    return ans1.toString();
	}
	
	public static void main(String[] args){
		Solution ss=new Solution();
		//System.out.println(ss.findDigitsInBinary(32));
		System.out.println(ss.reverse(-1146467285));
		System.out.println(ss.isPower(1));
		int c=100;
		char re=(char)c;
		System.out.println(re);
	}

}

