package com.skilldistillery.cardgame.entitites;

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
	
	public void showDeckShuffle() {
		String showCard = ""; 
		Collections.shuffle(cards);
		int i = 0;
		
		for (Card card : this.cards) {
			showCard += "\n" + i + card.toString();
			i ++; 
		}
		System.out.println(showCard);
	}
	
	
}
