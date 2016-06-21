package com.zyr.dm.impl;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Impl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int free[] = new int[12];
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i < 13; i++){
			System.out.print("第" + i +"周是否放假(0:不放假;1:放假): ");
			free[i-1] = sc.nextInt();
		}
		
		String str[] = {"A","C","D"};
		int num[] = {2,1,1};
		int numlen = num.length;
		int num1[] = new int[numlen];
		int num2[] = new int[numlen];
		for(int i = 0; i < num.length; i++){
		    num1[i] = 10 * num[i];
	    }
		
		int week[] = {1,2,1,1};
		int weeklen = week.length;
		int week1[] = new int[weeklen];
		String item[][] = new String[12][3];
		int count[] = new int[12];
		for(int i = 0; i < 12; i++){
		    count[i] = 0;
	    }
		int x = 10;
		while(week[0] > 0){
			x--;
			while(free[x-1] == 1){
				x--;
			}                  
			week[0]--;
		}
		week1[0] = x;
		
		int m = week1[0];
		
			while(week[1] > 0){
				m--;
				while(free[m-1] == 1){
					m--;
				}
				week[1]--;
			}
			week1[1] = m;
			m = week1[0];
		
		
		int n = week1[1];
		
			while(week[2] > 0){
				n--;
				while(free[n-1] == 1){
					n--;
				}
				week[2]--;
			}
			week1[2] = n;
			n = week1[1];
		
		
		
		
	
		int w1[] = new int[3];
		
			w1[0] = week1[0];

			w1[1] = week1[1];
			
			w1[2] = week1[2];
		
	
		for(int i = 0; i < 3; i++){
			item[w1[i]-1][count[w1[i]-1]] = num1[i] + str[i];
			count[w1[i]-1]++;
		}
	
		for(int i = 0; i < 12; i++){
			if(item[i][0] == null){
				continue;
			}
			System.out.print("第" + (i+1) + "周：");
			for(int j = 0; (j < 8) && (item[i][j] != null); j++){
				System.out.print(item[i][j] + " ");
			}
			System.out.print('\n');
		}
	}
}
