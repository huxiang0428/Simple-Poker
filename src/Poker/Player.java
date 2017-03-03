package Poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int id;
	private String name;
	private List<Poker> Pokers;

	public List<Poker> getPokers() {
		return Pokers;
	}

	public void setPokers(List<Poker> pokers) {
		Pokers = pokers;
	}

	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		Pokers = new ArrayList<Poker>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
