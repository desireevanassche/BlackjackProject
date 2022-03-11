package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cardsInHand;

	public Hand() {
		this.cardsInHand = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Hand [hand=" + cardsInHand + "]";
	}

	public void addCard(Card card) {
		this.cardsInHand.add(card);
	}

	public void discardHand() {
		this.cardsInHand.clear();
	}

	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}


}
