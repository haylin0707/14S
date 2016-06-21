package com.zyr.dm.impl;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Impl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int free[] = new int[10];//记录是否放假
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i < 11; i++){
			System.out.print("第" + i +"周是否放假(0:不放假;1:放假): ");//用户输入
			free[i-1] = sc.nextInt();
		}
		
		String str[] = {"X","A","B","E","C","D","R","O","P"};//物料名称
		int num[] = {1,1,4,1,1,1,4,1,1};
		int week[] = {1,2,1,3,1,2,2,1,2};//提前期
		int pi[] = {1,1,1,20,1,1,40,10,10};//批量
		int stock[] = {0,0,0,5,0,0,10,5,5};//库存
		int numlen = num.length;
		int num1[] = new int[numlen];//毛需求
		int jingnum[] = new int[numlen];//净需求
		int plannum[] = new int[numlen];//计划投入量
		for(int i = 0; i < numlen; i++){
		    num1[i] = 10 * num[i];
		    jingnum[i] = num1[i] - stock[i];
		    if(jingnum[i] < pi[i]){
		    	plannum[i] = pi[i];
		    }else{
		    	plannum[i] = jingnum[i];
		    }
		    stock[i] = plannum[i] - jingnum[i];
	    }
		
		int weeklen = week.length;
		int plan[] = new int[weeklen];//物料的计划投入时间
		//int week2[] = new int[weeklen];
		/*String item[][] = new String[10][9];
		int count[] = new int[10];
		for(int i = 0; i < 10; i++){
		    count[i] = 0;
	    }*/
		int x = 10;//第10周计划产出10个X
		while(week[0] > 0){
			x--;
			while(free[x-1] == 1){
				x--;
			}                  
			week[0]--;
		}
		plan[0] = x;//X的计划投入时间
		
		int m = plan[0];
		for(int i = 1; i < 4; i++){
			while(week[i] > 0){
				m--;
				while(free[m-1] == 1){
					m--;
				}
				week[i]--;
			}
			plan[i] = m;//A、B、E的计划投入时间
			m = plan[0];
		}
		
		int n = plan[1];
		for(int i = 4; i < 6; i++){
			while(week[i] > 0){
				n--;
				while(free[n-1] == 1){
					n--;
				}
				week[i]--;
			}
			plan[i] = n;//C、D的计划投入时间
			n = plan[1];
		}
		
		int o = plan[2];
		while(week[6] > 0){
			o--;
			while(free[o-1] == 1){
				o--;
			}
			week[6]--;
		}
		plan[6] = o;//R的计划投入时间
		
		int p = plan[4];
		while(week[7] > 0){
			p--;
			while(free[p-1] == 1){
				p--;
			}
			week[7]--;
		}
		plan[7] = p;//O的计划投入时间
		
		int q = plan[5];
		while(week[8] > 0){
			q--;
			while(free[q-1] == 1){
				q--;
			}
			week[8]--;
		}
		plan[8] = q;//P的计划投入时间
		
		System.out.print('\n');
		for(int i = 0; i < 9; i++){
			System.out.println(str[i] + ":在第" + plan[i] + "周计划投入量为" + num1[i] + "，产出之后库存量变为" + stock[i]);
		}
	
		//item[9-1][count[9-1]] = num1[0] + str[0];
		/*for(int i = 0; i < 9; i++){
			item[plan[i]-1][count[plan[i]-1]] = num1[i] + str[i];
			count[plan[i]-1]++;
		}
		
		
		for(int i = 0; i < 10; i++){
			if(item[i][0] == null){
				continue;
			}
			System.out.print("第" + (i+1) + "周：");
			for(int j = 0; (j < 9) && (item[i][j] != null); j++){
				System.out.print(item[i][j] + " ");
			}
			System.out.print('\n');
		}*/
	}
}
