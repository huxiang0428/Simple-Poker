package Poker;

import java.util.Comparator;

public class PokerComparator implements Comparator<Poker> {

	@Override
	public int compare(Poker o1, Poker o2) {
		if (o1.getNumber() > o2.getNumber()) {
			return 1;
		} else if (o1.getNumber() == o2.getNumber()) {
			if (o1.getHuasenum() > o2.getHuasenum()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
