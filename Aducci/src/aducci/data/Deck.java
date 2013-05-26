package aducci.data;

import java.util.List;

public class Deck {
	public List<Integer> main;
	public List<Integer> side;
	
	public Deck(List<Integer> main, List<Integer> side) {
		this.main = main;
		this.side = side;	
	}
}
