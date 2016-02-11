package com.Level2.Arrays.repeatarr;

import java.util.Arrays;
import java.util.List;

public class Solution {
	
	
	
	public static int repeatedNumber(final List<Integer> a) {
	    Integer[] b= new Integer[a.size()];
	    for(int i=0;i<a.size();i++){
	    	b[i]=0;
	    }
	    for(int i=0;i<a.size();i++){
	    	//System.out.println(a.get(i));
	        b[a.get(i)]=b[a.get(i)]+1;
	        if(b[a.get(i)]>1){
	            return a.get(i);
	        }
	    }
	    return -1;
	    
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] i={new Integer(3) ,new Integer(4) ,new Integer(1) ,new Integer(4) ,new Integer(1)};
		List<Integer> aa=Arrays.asList(i);
		System.out.println(repeatedNumber(aa));

	}

}
