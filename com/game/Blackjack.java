import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//两个游戏角色 庄家 玩家
//列表

//发牌
//每个人两张牌，庄家有一张暗牌

//要牌
//接收用户输入，获得一个输入指令，
//输入1，要牌
//输入0,不要牌

//判断输赢
//比较点数之和的大小，判断输赢

public class Blackjack {
	ArrayList<Integer> banker = new ArrayList<Integer>();
	ArrayList<Integer> player = new ArrayList<Integer>();
	Random random = new Random();
	
	//牌的点数 2~11
	//发牌
	public void deal(){
		for(int i =0;i<2;i++){
			banker.add(random.nextInt(10)+2);
			player.add(random.nextInt(10)+2);
		}
		
//		%d %f %.2f %s
		System.out.printf("庄家的点数是%d和%s\n", banker.get(0),"X");
//		System.out.println();
		System.out.printf("闲家的点数是%d和%d\n", player.get(0),player.get(1));
	
	}
	
	//游戏控制流程
	public void play(){
		deal();
//		InputStream
		while(true){
			Scanner scanner = new Scanner(System.in);
			int cmd = scanner.nextInt();
			if(cmd == 1){
				player.add(random.nextInt(10)+2);

				int sum = player.stream().mapToInt(e->e.intValue()).sum();
//				int sum = 0;
//				for(int i=0;i<player.size();i++){
//					sum+=player.get(i);
//				}
				if(sum>=21){
					isWin();
					break;
				}
				
			}else if(cmd == 0){
				//不要牌
				System.out.println("庄家的暗牌是:"+banker.get(1));
				int banker_sum = banker.stream().mapToInt(e->e.intValue()).sum();
				while(banker_sum<=17){
					int b=random.nextInt(10)+2;
					banker.add(b);
					banker_sum+=b;
				}
				isWin();
				break;
			}
		}
				
	}
	
	//
	public void isWin(){
		
	}
	
	public static void main(String args[]){
		Blackjack blackjack = new Blackjack();
		blackjack.deal();
	}

}
