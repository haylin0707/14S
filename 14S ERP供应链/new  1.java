import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Top {

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
		}//确定这周是否放假，如果放假则不进行生产
		
		String str[] = {“X","A","C","D"};
		int num[] = {1,2,2,2};//分别对应一个X要2个A，2个C，2个D
		int pi[] = {1,1,1,50};//批量
		int stock[] = {0,0,0,10};//库存
		int numlen = num.length;
		int num1[] = new int[numlen];//毛需求
	    int jingnum[] = new int[numlen];//净需求
		int plannum[] = new int[numlen];//计划投入量
		
		for(int i = 0; i < numlen; i++){
		    num1[i] = 10 * num[i];
		    jingnum[i] = num1[i] - stock[i];//净需求=毛需求-库存
		    if(jingnum[i] < pi[i]){
				//如果净需求<批量，则计划投入量按照批量生产
		    	plannum[i] = pi[i];
		    }else{
				//否则按照净需求生产
		    	plannum[i] = jingnum[i];
		    }
		    stock[i] = plannum[i] - jingnum[i];
			//最后库存=计划投入量-净需求量
	    }
		
		int week[] = {1,2,1,1};//分别对应X，A，C，D的提前期
		int weeklen = week.length;
		int plan[] = new int[weeklen];//物料的计划投入时间
		String item[][] = new String[12][3];
		int count[] = new int[12];
		for(int i = 0; i < 12; i++){
		    count[i] = 0;
	    }
		
		int x = 9;//假设第9周要生产处10个X
		while(week[0] > 0){
			x--;//由于提前期依次往前推，知道为0
			while(free[x-1] == 1){
				x--;//如果该周期不工作，则再往前推一期
			}                  
			week[0]--;
		}
		plan[0] = x;//plan[0]即是计划投入生产X的开始时间
		
		
		
		int m = plan[0];//m即是X的开始时间
		
			while(week[1] > 0){//看A的提前期
				m--;//X的开始代表A的结束，所以由m往前推
				while(free[m-1] == 1){
					m--;
				}
				week[1]--;
			}
			plan[1] = m;//plan[1]即是计划投入生产A的开始时间
			m = plan[0];
		
		
		int n = plan[1];//n即是A的开始时间
		
			while(week[2] > 0){//看C的提前期
				n--;//A的开始代表C的结束，所以由n往前推
				while(free[n-1] == 1){
					n--;
				}
				week[2]--;
			}
			plan[2] = n;//week1[2]即是计划投入生产C的开始时间
			n = plan[1];
	
	
	    int o = plan[2];//o即是C的开始时间
		
			while(week[3] > 0){//看D的提前期
				o--;//C的开始代表D的结束，所以由o往前推
				while(free[o-1] == 1){
					o--;
				}
				week[3]--;
			}
			plan[3] = o;
			
		System.out.print('\n');
		for(int i = 0; i < 4; i++){
			System.out.println(str[i] + ":在第" + plan[i] + "周计划投入量为" 
			+ plan[i] + "，产出之后库存量变为" + stock[i]);
		}
	}
}
