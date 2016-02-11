package com.Arrays.pacal2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public ArrayList<Integer> getRow(int a) {
		ArrayList<Integer>ans=new ArrayList<>();
	    if(a==0){
	        ans.add(1);
	        return ans;
	    }
	    if(a==1){
	        ans.add(1);
	        ans.add(1);
	        return ans;
	    }else{
	        ans.add(1);
	        ans.add(1);
	        int index=1;
	        int count=0;
	        for(int i=0;i<(a-1);i++){
    	        if(count< a/2){
    	            ans.add(index, ( getRow(a-1).get(i)+getRow(a-1).get(i+1) ) );
    	            count++;
    	        //ans.add(a-1-index, ( getRow(a-1).get(i)+getRow(a-1).get(i+1) ) );
    	        } else{
    	            ans.add(index, ( ans.get(a-index)));
    	            count--;
    	        } 
    	        index++ ;    
    	    }
    	    /*for(int i=0;i<(a-1);i++){
    	       ans.add(index, ( getRow(a-1).get(i)+getRow(a-1).get(i+1) ) );
    	        index++ ;    
    	    }*/
	    }
	    return ans;
	}

	public static void main(String[] args) {
		String a="1967513926, 1540383426, -1303455736, -521595368";
		StringBuilder sb=new StringBuilder();
		List<Integer> ans=new ArrayList<>();
		for(int i=0; i<a.length();i++){
			 
			if((a.charAt(i)>='0'&& a.charAt(i)<='9' )|| a.charAt(i)=='-' ){
				sb.append(a.charAt(i));
				
			}			
			else if(a.charAt(i)==','){
				// Note taking integer as input
				ans.add(Integer.parseInt(sb.toString()));
				sb=new StringBuilder();
			}
		}
		ans.add(Integer.parseInt(sb.toString()));
		Collections.sort(ans);
		System.out.println(ans);
		
		

	}

}
