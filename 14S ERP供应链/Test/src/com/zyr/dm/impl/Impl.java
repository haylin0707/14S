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
		int free[] = new int[10];//记录是否放假
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i < 11; i++){
			System.out.print("第" + i +"周是否放假(0:不放假;1:放假): ");
			free[i-1] = sc.nextInt();
		}
		
		String str[] = {"A","B","E","C","D","R","O","P"};
		int num[] = {1,4,1,1,1,1,1,1};
		int numlen = num.length;
		int num1[] = new int[numlen];
		int num2[] = new int[numlen];
		for(int i = 0; i < num.length; i++){
		    num1[i] = 10 * num[i];
		    num2[i] = 5 * num[i];
	    }
		int week[] = {1,2,1,1,1};
		int weeklen = week.length;
		int week1[] = new int[weeklen];
		int week2[] = new int[weeklen];
		String item[][] = new String[10][8];
		int count[] = new int[10];
		for(int i = 0; i < 10; i++){
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
		for(int i = 1; i < 3; i++){
			while(week[i] > 0){
				m--;
				while(free[m-1] == 1){
					m--;
				}
				week[i]--;
			}
			week1[i] = m;
			m = week1[0];
		}
		
		int n = week1[1];
		for(int i = 3; i < 5; i++){
			while(week[i] > 0){
				n--;
				while(free[n-1] == 1){
					n--;
				}
				week[i]--;
			}
			week1[i] = n;
			n = week1[1];
		}
		
		int week3[] = {1,2,1,1,1};
		
		int x1 = 9;
		while(week3[0] > 0){
			x1--;
			while(free[x1-1] == 1){
				x1--;
			}                  
			week3[0]--;
		}
		week2[0] = x1;
		
		int m1 = week2[0];
		for(int i = 1; i < 3; i++){
			while(week3[i] > 0){
				m1--;
				while(free[m1-1] == 1){
					m1--;
				}
				week3[i]--;
			}
			week2[i] = m1;
			m1 = week2[0];
		}
		
		int n1 = week2[1];
		for(int i = 3; i < 5; i++){
			while(week3[i] > 0){
				n1--;
				while(free[n1-1] == 1){
					n1--;
				}
				week3[i]--;
			}
			week2[i] = n1;
			n1 = week2[1];
		}
	
		int w1[] = new int[8];
		int w2[] = new int[8];
		for(int i = 0; i < 3; i++){
			w1[i] = week1[0];
			w2[i] = week2[0];
		}
		for(int i = 3; i < 5; i++){
			w1[i] = week1[1];
			w2[i] = week2[1];
		}
		for(int i = 5; i < 8; i++){
			w1[i] = week1[i-3];
			w2[i] = week2[i-3];
		}
		for(int i = 0; i < 8; i++){
			item[w1[i]-1][count[w1[i]-1]] = num1[i] + str[i];
			count[w1[i]-1]++;
		}
		for(int i = 0; i < 8; i++){
			item[w2[i]-1][count[w2[i]-1]] = num2[i] + str[i];
			count[w2[i]-1]++;
		}
		
		for(int i = 0; i < 10; i++){
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
