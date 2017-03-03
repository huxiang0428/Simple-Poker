package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class PokerGame implements Comparator<Poker>{

	private String[] huase = {"黑桃", "红桃", "梅花", "方块"};
	private String[] mask = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
			"Q", "K", "A"};
	private ArrayList<Poker> pokerList;
	private HashMap<Integer, Player> playerMap;
	private Scanner console;
	private int a;
	private int b;

	public PokerGame() {
		pokerList = new ArrayList<Poker>();
		playerMap = new HashMap<Integer, Player>();
		console = new Scanner(System.in);
	}
	public void createPoker() {
		System.out.println("------------创建扑克牌----------");
		for (int j = 0; j < 4; j++) {
			for (int i = 2; i < 15; i++) {
				pokerList.add(new Poker(huase[j], mask[i - 2], i, j));
			}
		}
		System.out.println("------------创建成功-----------");
		for (Poker poker : pokerList) {
			System.out.print(poker.toString() + ",");
		}
		System.out.println("");
	}
	public void xiPoker() {
		System.out.println("------------开始洗牌-----------");
		// 或者放入set中
		Collections.shuffle(pokerList);
		System.out.println("------------洗牌结束-----------");
		// for (Poker poker : pokerList) {
		// System.out.print(poker.toString() + ",");
		// }
	}
	public void createPlayer() {
		System.out.println("------------创建玩家-----------");
		for (int i = 0; i < 2;) {
			System.out.println("请输入第" + (i + 1) + "位玩家的ID和姓名：");
			System.out.println("请输入玩家的ID：");
			int id = 0;
			try {
				id = console.nextInt();
			} catch (Exception e) {
				System.out.println("输入异常，请输入整数类型的ID");
				console.next();
				continue;
			}
			//ID不能重复 用Map的键值对来实现
			Player p = playerMap.get(id);
			if (p == null) {
				System.out.println("请输入玩家的姓名：");
				String name = console.next();
				playerMap.put(id, new Player(id, name));
				System.out.println("添加成功！");
				//避免重复赋值 ！
				switch (i) {
					case 0 :
						a = id;
					case 1 :
						b = id;
				}
			} else {
				System.out.println("该ID已经被占用，请重新添加！");
				continue;
			}
			i++;
		}
	}
	// public int scanInt() throws Exception {
	// try {
	// int in = console.nextInt();
	// return in;
	// } catch (Exception e) {
	// console = new Scanner(System.in);
	// throw new Exception("输入异常，请输入整数类型的ID");
	// }
	// }
	public void beginGame() {
		System.out.println("欢迎玩家" + playerMap.get(a).getName() + ","
				+ playerMap.get(b).getName());
		System.out.println("----------开始发牌-------------");
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				System.out.println(playerMap.get(a).getName() + "得到第" + (i + 1)
						+ "张牌");
				playerMap.get(a).getPokers().add(pokerList.get(i));
			} else {
				System.out.println(playerMap.get(b).getName() + "得到第" + (i + 1)
						+ "张牌");
				playerMap.get(b).getPokers().add(pokerList.get(i));
			}
		}
		System.out.println("----------发牌结束！------------");
		System.out.println("----------开始游戏!-------------");
		System.out.println("玩家各自手牌为");
		Poker a1 = playerMap.get(a).getPokers().get(0);
		Poker a2 = playerMap.get(a).getPokers().get(1);
		System.out.println(playerMap.get(a).getName() + ":" + a1.toString()
				+ "," + a2.toString());
		Poker b1 = playerMap.get(b).getPokers().get(0);
		Poker b2 = playerMap.get(b).getPokers().get(1);
		System.out.println(playerMap.get(b).getName() + ":" + b1.toString()
				+ "," + b2.toString());
		System.out.println("------------------------------");
		// PokerComparator pC = new PokerComparator();
//		Poker aMax = a1.compareTo(a2)>0 ? a1:a2;
		Poker aMax = compare(a1, a2) > 0 ? a1 : a2;
		System.out.println("玩家" + playerMap.get(a).getName() + "最大的手牌是"
				+ aMax.toString());
		Poker bMax = compare(b1, b2) > 0 ? b1 : b2;
		System.out.println("玩家" + playerMap.get(b).getName() + "最大的手牌是"
				+ bMax.toString());
		if (compare(aMax, bMax) > 0) {
			System.out.println("--------玩家" + playerMap.get(a).getName()
					+ "获得胜利！----------");
		} else {
			System.out.println("--------玩家" + playerMap.get(b).getName()
					+ "获得胜利！----------");
		}
	}
	@Override
	public int compare(Poker o1, Poker o2) {
		if (o1.getNumber() > o2.getNumber()) {
			return 1;
		} else if (o1.getNumber() == o2.getNumber()) {
			if (o1.getHuasenum() > o2.getHuasenum()) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return -1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PokerGame fapai = new PokerGame();
		fapai.createPoker();
		fapai.xiPoker();
		fapai.createPlayer();
		fapai.beginGame();
	}

}
