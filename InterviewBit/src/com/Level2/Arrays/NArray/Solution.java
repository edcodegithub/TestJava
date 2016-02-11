package com.Level2.Arrays.NArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    int n= a.size();
	    int x=0;
	    int y=0;
	    Integer oSum=n*(n+1)/2;
	    Integer  pSum=0;
	    ArrayList<Integer> ans=new ArrayList<>();
	    for(int i=0;i<n;i++){
	        pSum^=a.get(i);
	    }
	    for(int i=1;i<=n;i++){
	        pSum^=i;
	    }
	    Integer set_bit_no = pSum & ~(pSum-1);
	    for(int i = 0; i < n; i++)
	    {
	      if((a.get(i) & set_bit_no)>0)
	       x = x ^ a.get(i); /* arr[i] belongs to first set */
	      else
	       y = y ^ a.get(i); /* arr[i] belongs to second set*/
	    }
	    for(int i = 1; i <= n; i++)
	    {
	    	int t=i &set_bit_no;
	      if(t>0)
	       x = x ^ i; /* i belongs to first set */
	      else
	       y = y ^ i; /* i belongs to second set*/
	    }
	    if(a.contains(x)){
	    	int temp=x;
	    	x=y;
	    	y=temp;
	    }
	    ans.add(x);
	    ans.add(y);
	    return ans;
	   
	    /* Now *x and *y hold the desired output elements */
	  }
	    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int xor1=1^2^2^4^5^6;
		 int set_bit_no = (6) & ~(5);//xor1 & ~(xor1-1);
		 System.out.println(set_bit_no);

	}

}
