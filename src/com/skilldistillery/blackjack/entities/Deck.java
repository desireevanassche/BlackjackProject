package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
			cards.add(new Card(suit, rank));
			}
		}

	}

	
	public int checkDeckSize() {
		int size = cards.size();
		
		return size;
		
	}
	
	public Card dealCard() {
		return cards.remove(0);
		
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	
}
