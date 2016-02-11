package com.Level2.Arrays.Positive;

import java.util.ArrayList;

public class Solution {
	public void swap(int a, int b)
	{
	    int temp;
	    temp = a;
	    a   = b;
	    b   = temp;
	}
	public int segregate (ArrayList<Integer> a)
	{
	    int j = 0;
	    for(int i = 0; i < a.size(); i++)
	    {
	       if (a.get(i) <= 0)  
	       {
	           swap(a.get(i), a.get(j));
	           j++;  // increment count of non-positive integers
	       }
	    }
	 
	    return j;
	}
	
	public int findMissingPositive(ArrayList<Integer> a, int size)
	{
	  
	 
	  // Mark arr[i] as visited by making arr[arr[i] - 1] negative. Note that 
	  // 1 is subtracted because index start from 0 and positive numbers start from 1
	  for(int i = 0; i < size; i++)
	  {
	    if(Math.abs(a.get(i)) - 1 < a.size() && a.get(Math.abs(a.get(i))-1) > 0)
	    	a.set((Math.abs(a.get(i))-1),(Math.abs(a.get(i))-1)); 
	  }
	 
	  // Return the first index value at which is positive
	  for(int i = 0; i < size; i++)
	    if (a.get(i) > 0)
	      return i+1;  // 1 is added becuase indexes start from 0
	 
	  return size+1;
	}
	int firstMissingPositiveAnd0(int A[]) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			// when the ith element is not i
			while (A[i] != i) {
				// no need to swap when ith element is out of range [0,n]
				if (A[i] < 0 || A[i] >= n)
					break;
	 
				//handle duplicate elements
				if(A[i]==A[A[i]])
	                    		break;
				// swap elements
				int temp = A[i];
				A[i] = A[temp];
				A[temp] = temp;
			}
		}
	 
		for (int i = 0; i < n; i++) {
			if (A[i] != i)
				return i;
		}
	 
		return n;
	}
	
	public int firstMissingPositive(ArrayList<Integer> a) {
		int n = a.size();
		 
    	for (int i = 0; i < n; i++) {
    		while (a.get(i) != i + 1) {
    			if (a.get(i) <= 0 || a.get(i) >= n)
    				break;
 
                	if(a.get(i)==a.get(a.get(i)-1))
                    		break;
                    int temp = a.get(i);
                	a.set(i, a.get(temp-1));
                	a.set(temp - 1, temp);
 
    			
    		}
    	}
 
    	for (int i = 0; i < n; i++){
    		if (a.get(i) != i + 1){
    			return i + 1;
    		}
    	}	
 
    	return n + 1;
	    
	}

	public static void main(String[] args){
		int a=6;
		int b=1;
		int d =a^b;
		System.out.println(d);
	}
}
