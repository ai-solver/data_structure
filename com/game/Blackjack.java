import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//������Ϸ��ɫ ׯ�� ���
//�б�

//����
//ÿ���������ƣ�ׯ����һ�Ű���

//Ҫ��
//�����û����룬���һ������ָ�
//����1��Ҫ��
//����0,��Ҫ��

//�ж���Ӯ
//�Ƚϵ���֮�͵Ĵ�С���ж���Ӯ

public class Blackjack {
	ArrayList<Integer> banker = new ArrayList<Integer>();
	ArrayList<Integer> player = new ArrayList<Integer>();
	Random random = new Random();
	
	//�Ƶĵ��� 2~11
	//����
	public void deal(){
		for(int i =0;i<2;i++){
			banker.add(random.nextInt(10)+2);
			player.add(random.nextInt(10)+2);
		}
		
//		%d %f %.2f %s
		System.out.printf("ׯ�ҵĵ�����%d��%s\n", banker.get(0),"X");
//		System.out.println();
		System.out.printf("�мҵĵ�����%d��%d\n", player.get(0),player.get(1));
	
	}
	
	//��Ϸ��������
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
				//��Ҫ��
				System.out.println("ׯ�ҵİ�����:"+banker.get(1));
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
