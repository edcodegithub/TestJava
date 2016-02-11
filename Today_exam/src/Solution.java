import java.util.Scanner;


public class Solution {
	static int getIntegerComplement(int n) {
        String s=Integer.toBinaryString(n);
        int lm=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
            	lm= (int) (lm+Math.pow(2,s.length()-1-i ));
            }
        }
		return lm;


    }

	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int res;
	        int _n;
	        _n = Integer.parseInt(in.nextLine());
	        
	        res = getIntegerComplement(_n);
	        System.out.println(res);
	        
	    }
	}

