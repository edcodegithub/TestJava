package com.Level2.Coin.Flip;

import java.io.*;


public class Solution {	

	public static void main(String[] args) {
		int[] a= new int[args.length];
		for (int i=0;i<args.length; i++){
			a[i]= Integer.parseInt("010111000");
		}
		int maxnum=flip(a);
		System.out.println(maxnum);
					
		}
	public static int flip(int a[])	{
		int max=0;
		int count=0;
		int left,right;
		int[] b = new int[a.length];
		System.arraycopy( a, 0, b, 0, a.length );
		
		for(left=0;left<b.length;left++)	{
			for(right=left;right<b.length;right++)	{
				for(int i=left;i<=right;i++)	{
					if(b[i]==1)
						b[i]=0;
					else
						b[i]=1;
				}
				for(int j=0;j<b.length;j++)	{
					if(b[j]==1)
						count++;
				}
				b=new int[a.length];
				System.arraycopy( a, 0, b, 0, a.length );
				if(max<count)
					max=count;
				count=0;
			}
		}
		return max;
	}

}