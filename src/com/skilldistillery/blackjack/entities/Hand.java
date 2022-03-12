package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cardgame.entitites.Card;

public abstract class Hand {
	protected List<Card> cardsInHand;

	public Hand() {
		this.cardsInHand = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Hand: " + cardsInHand;
	}

	public void addCard(Card card) {
		this.cardsInHand.add(card);
	}

	public void discardHand() {
		this.cardsInHand.clear();
	}
	
	public List<Card> getCards() {
		return cardsInHand;
	}

	public int getHandValue() {
		return 0;
	}


}
