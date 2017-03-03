package Poker;

public class Poker  {

	private String huase;
	private String mask;
	private int number;
	private int huasenum;

	public int getHuasenum() {
		return huasenum;
	}
	public void setHuasenum(int huasenum) {
		this.huasenum = huasenum;
	}
	public Poker(String huase, String mask, int number, int huasenum) {
		this.huase = huase;
		this.mask = mask;
		this.number = number;
		this.huasenum = huasenum;
	}
	public String toString() {
		return huase + mask;
	}
	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getHuase() {
		return huase;
	}

	public void setHuase(String huase) {
		this.huase = huase;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
//	@Override
//	public int compareTo(Poker o2) {
//		if (this.getNumber() > o2.getNumber()) {
//			return 1;
//		} else if (this.getNumber() == o2.getNumber()) {
//			if (this.getHuasenum() > o2.getHuasenum()) {
//				return -1;
//			} else {
//				return 1;
//			}
//		} else {
//			return -1;
//		}
//	}
}
