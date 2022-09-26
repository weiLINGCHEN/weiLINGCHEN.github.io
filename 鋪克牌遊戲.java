import java.util.Scanner;

public class B05610015_hw11 {
	private static int point;
	private static int choose=1;
	private static int game=-1;
	private static int order=0;
	private static int flower=0;
	
	public static void printbegin() {
		System.out.println("====Welcome to the Poker Game====");
		System.out.println("1:開始撲克牌遊戲:");
		System.out.println("2:結束遊戲");
		System.out.println("=================================");
		gamenum();
		System.out.println();
		System.out.println("請輸入您的選擇(1 or 2):");
		System.out.println();
	}
	//尋找花色的方法
	public static String []flower(int []input) {
		
		String []flower=new String [5];
		for(int i=0;i<input.length;i++) {
			if(input[i]>=1&&input[i]<=13) {
				flower[i]="黑桃♠";
				}else if(input[i]>=14&&input[i]<=26) {
				flower[i]="紅心♥";
				}else if(input[i]>=27&&input[i]<=39) {
					flower[i]="方塊♦";
				}else if(input[i]>=40&&input[i]<=52) {
						flower[i]="梅花♣";
				}
		}
		return flower;	
	}
	
	//所輸入五張牌為
	public static void addFlower(int input[]) {
		int test = 0;
		String b[]=new String[5];
		b=flower(input);
		for(int i=0;i<4;i++) {
			boolean equal=b[i].equals(b[i+1]);
			if(equal==false) {
				flower=1;
				break;
			}else if(i==3&&equal==true) {
				flower=2;
			}
		}
	
		String a[]=new String[5];
		System.out.println("所輸入五張牌為：");
		for(int i=0;i<5;i++) {
			if(input[i]==1||input[i]==14||input[i]==27||input[i]==40) {
				a[i]="A";
			}else if(input[i]==2||input[i]==15||input[i]==28||input[i]==41){
				a[i]="2";
			}else if(input[i]==3||input[i]==16||input[i]==29||input[i]==42){
				a[i]="3";
			}else if(input[i]==4||input[i]==17||input[i]==30||input[i]==43){
				a[i]="4";
			}else if(input[i]==5||input[i]==18||input[i]==31||input[i]==44){
				a[i]="5";
			}else if(input[i]==6||input[i]==19||input[i]==32||input[i]==45){
				a[i]="6";
			}else if(input[i]==7||input[i]==20||input[i]==33||input[i]==46){
				a[i]="7";
			}else if(input[i]==8||input[i]==21||input[i]==34||input[i]==47){
				a[i]="8";
			}else if(input[i]==9||input[i]==22||input[i]==35||input[i]==48){
				a[i]="9";
			}else if(input[i]==10||input[i]==23||input[i]==36||input[i]==49){
				a[i]="10";
			}else if(input[i]==11||input[i]==24||input[i]==37||input[i]==50){
				a[i]="J";
			}else if(input[i]==12||input[i]==25||input[i]==38||input[i]==51){
				a[i]="Q";
			}else if(input[i]==13||input[i]==26||input[i]==39||input[i]==52){
				a[i]="K";
			}
			
			b[i]=b[i]+a[i];
			System.out.print(b[i]+" ");
		}
		if(flower==1) {
			System.out.print("不同花色");
		}else if(flower==2) {
			System.out.print("同花色");
		}
		System.out.println();
		
		
			
	}
	
	public static void gamenum() {
		game++;
		//呼叫一個計算分數 ㄉ method!
		if(game>=1) {
			System.out.println("你已經經過"+game+"場撲克牌遊戲，累積分數為"+point+"分");
		}
	}
	
	public static void order(int input[]) {
		
		for(int i=0;i<5;i++) {
			if(input[i]==1||input[i]==14||input[i]==27||input[i]==40) {
				input[i]=1;
			}else if(input[i]==2||input[i]==15||input[i]==28||input[i]==41){
				input[i]=2;
			}else if(input[i]==3||input[i]==16||input[i]==29||input[i]==42){
				input[i]=3;
			}else if(input[i]==4||input[i]==17||input[i]==30||input[i]==43){
				input[i]=4;
			}else if(input[i]==5||input[i]==18||input[i]==31||input[i]==44){
				input[i]=5;
			}else if(input[i]==6||input[i]==19||input[i]==32||input[i]==45){
				input[i]=6;
			}else if(input[i]==7||input[i]==20||input[i]==33||input[i]==46){
				input[i]=7;
			}else if(input[i]==8||input[i]==21||input[i]==34||input[i]==47){
				input[i]=8;
			}else if(input[i]==9||input[i]==22||input[i]==35||input[i]==48){
				input[i]=9;
			}else if(input[i]==10||input[i]==23||input[i]==36||input[i]==49){
				input[i]=10;
			}else if(input[i]==11||input[i]==24||input[i]==37||input[i]==50){
				input[i]=11;
			}else if(input[i]==12||input[i]==25||input[i]==38||input[i]==51){
				input[i]=12;
			}else if(input[i]==13||input[i]==26||input[i]==39||input[i]==52){
				input[i]=13;
			}
		}
		for(int j=(input.length-2);j>=0;j--) {
			for(int i=0;i<=j;i++) {
				if(input[i]>input[i+1]) {
				int bigger=input[i+1];
				input[i+1]=input[i];
				input[i]=bigger;
				}
				}
			}
		order=determineNum(input);
			
		System.out.print("排序後之撲克牌號碼為:");
		for(int j=0;j<input.length;j++)
			System.out.print(input[j]+" ");
		if(order==1) {
			System.out.print("此為連續數列，");
		}else if(order==3) {
			System.out.print("，A 在此視為 14，所以數列為 10, 11, 12, 13, 14，此為連續數列，");
		
		}else{
		
			System.out.print("此為不連續數列，");
			determineNum2(input);
		}
			
	}
	
	//不連續數列判斷
	public static void determineNum2(int[]a) {
		if((a[0]==a[1]&&a[1]==a[2]&&a[4]==a[3])||(a[4]==a[3]&&a[3]==a[2]&&a[1]==a[0])) {
			System.out.println("「葫蘆」，得分5分！");
			point+=5;
		}else if((a[0]==a[1]&&a[1]==a[2]&&a[2]==a[3])||(a[4]==a[3]&&a[3]==a[2]&&a[2]==a[1])) {
			System.out.println("「四條」，得分6分！");
			point+=6;
		}else if((a[0]==a[2]&&a[2]!=a[3]&&a[4]!=a[3])||(a[1]==a[2]&&a[2]!=a[1]&&a[1]!=a[0])||(a[1]==a[3]&&a[0]!=a[1]&&a[1]!=a[4])) {
			System.out.println("「三條」，得分3分！");
			point+=3;
		}else if((a[0]==a[1]&&a[1]!=a[2]&&a[2]==a[3]&&a[3]!=a[4])||(a[4]==a[3]&&a[3]!=a[2]&&a[2]==a[1]&&a[1]!=a[0])||(a[0]==a[1]&&a[1]!=a[2]&&a[2]!=a[3]&&a[3]==a[4])) {
			System.out.println("「兩對」，得分2分！");
			point+=2;
		}else if((a[0]==a[1]&&a[1]!=a[2]&&a[2]!=a[3]&&a[3]!=a[4])||(a[1]==a[2]&&a[0]!=a[1]&&a[2]!=a[3]&&a[3]!=a[4])||(a[2]==a[3]&&a[0]!=a[1]&&a[1]!=a[2]&&a[3]!=a[4])||(a[3]==a[4]&&a[0]!=a[1]&&a[1]!=a[2]&&a[2]!=a[3])) {
			System.out.println("「一對」，得分1分！");
			point+=1;
		}else {
			System.out.println("「雜牌」，得分0分");
		}
	}
	
	//順子判斷
	public static int determineNum(int[]a) {
		int b=1;
		if(a[0]==a[1]-1&&a[1]==a[2]-1&&a[2]==a[3]-1&&a[3]==a[4]-1) {
			}else if(a[0]==1&&a[1]==10&&a[2]==11&&a[3]==12&&a[4]==13) {
			b=3;
				
			}
		else {
			b=2;
		}
		
		return b;
			
	}

	
	
	public static void main(String[] args) {
		
		do {
			
		
		printbegin();
		
		Scanner scn=new Scanner(System.in);
		choose=scn.nextInt();
		if(choose==1) {
			
			System.out.println("請輸入 5 個整數，用以判斷撲克牌之種類與得分，範圍為 1~52 之不重複整數，中間以空格\n" + 
					"區分:");
			int inputNum[]=new int[5];
			for(int i=0;i<5;i++) {
				inputNum[i]=scn.nextInt();}
			addFlower(inputNum);
			order(inputNum);
			if((order==1||order==3)&&flower==2) {
				point+=7;
				System.out.println("「同花順」，得分7分!");
			}else if((order==3||order==1)&&flower==1) {
				point+=4;
				System.out.println("「順子」，得分4分!");
				
			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
			//放一個method
	
	
	}while(choose==1);
		System.out.print("遊戲結束, bye bye!");

}
}
