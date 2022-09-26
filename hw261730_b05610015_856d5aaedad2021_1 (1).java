import java.util.Scanner;

public class B05610015_hw10 {


	public static void main(String[] args) {
		 java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");  
			int input=0;
			int playtime=0;
			int sumT=0;
			int wintime=0;
			double avgwin=0;
			int loose=0;
			double winRate=0;
		
		do {
			System.out.println();
			System.out.println("===Welcome To The Game===");
			System.out.println("1:開始新遊戲");
			System.out.println("2:過去遊戲歷史記錄");
			System.out.println("3:結束遊戲");
			System.out.println("=========================");
			System.out.println("請輸入您的選擇(1, 2, or 3):");
			
			
			Scanner scn=new Scanner(System.in);
			input=scn.nextInt();
			
			if(input==1) {
				playtime++;
				int A,B,C,D,X=0,Y=0,T=0;
				int num[]=new int[] {0,1,2,3,4,5,6,7,8,9};
				for(int i=0;i<100;i++) {
					double x = Math.random();
					int x1=(int)(10*x);
					double y = Math.random();
					int y1=(int)(10*y);
					int place=0;
					place=num[x1];
					num[x1]=num[y1];
					num[y1]=place;
				}
				A=num[0];
				B=num[1];
				C=num[2];
				D=num[3];
				int[] order = new int [] {A,B,C,D};
				//測試答案
				System.out.println("答案為："+A+""+B+""+C+""+D);
				String docu[]=new String[10];
				loop1:for(int i=0;i<10;i++) {
				T++;
				X=0;
				Y=0;
				System.out.println();
				if(i+1==8) {
				System.out.println("第"+(i+1)+"次猜答: 請輸入四位數字, 數字不重複:");
				System.out.println("答案提示：X"+B+"X"+D);
				}else {
					System.out.println("第"+(i+1)+"次猜答: 請輸入四位數字, 數字不重複:");
				}
				int a = scn.nextInt();	
				int A1,B1,C1,D1;
				A1=a/1000;
				B1=a/100-a/1000*10;
				C1=a/10-a/100*10;
				D1=a%10;
				int[] num1 = new int [] {A1,B1,C1,D1};
				for(int j = 0;j<order.length;j++)
					for(int i1 = 0;i1<num1.length;i1++)
						if(order[j]==num1[i1]&&j==i1)
							X++;//A次數
				for(int j = 0;j<order.length;j++)
					for(int i1 = 0;i1<num1.length;i1++)
						if(order[j]==num1[i1]&&j!=i1)
							Y++;//B次數
				if (X==4) {
					break loop1;}
				
				
				for(int j=T-1;j<T;j++)
					docu[j]=(A1+""+B1+""+C1+""+D1+", "+X+"A"+Y+"B");
				
				System.out.println("比較結果為：");
				
				for(int k=0;k<T;k++)
					System.out.println(docu[k]);
				
				System.out.println("--------------------------");
				}

				if(T<=10&&X==4) {
					System.out.println("比較結果為：");
					
					for(int k=0;k<T-1;k++)
						System.out.println(docu[k]);
					System.out.println(A+""+B+""+C+""+D+", 答對了! Bingo!!!");
					System.out.println("--------------------------");
					sumT=sumT+T;
					wintime++;
					avgwin=((double)sumT/wintime);
					winRate=((double)wintime/playtime);		
				}
				else if(T==10&&X!=4) {
					System.out.println("已猜答超過10次, 失敗! 答案為:");
					System.out.println(A+""+B+""+C+""+D);
					loose++;
					winRate=((double)wintime/playtime);
				}
				
			}else if(input==2) {
				if(playtime==0) {
					System.out.println("尚無遊戲歷史記錄!");
				}else {
					
					System.out.println("總共遊戲次數:"+playtime);
					
					if(wintime==0) {
					System.out.println("總共猜中次數:0");
					}else {
						System.out.println("總共猜中次數:"+wintime+", 平均"+df.format(avgwin)+"回合猜中");
						}
					System.out.println("總共失敗次數:"+loose);
					
					if(wintime==0) {
						System.out.println("總共勝率為:0.00");
						
					}else {
					System.out.println("總共勝率為:"+df.format(winRate));}
				
				
				}
		
			}
			
		}while(input==1||input==2);
		
		System.out.println("遊戲結束, Bye Bye!");
		
		
	}	

}
