package com.skilldistillery.blackjack.entities;

import com.skilldistillery.cardgame.entitites.Card;

public class BlackJackHand extends Hand {
	
	public boolean isBust() {
		int sumOfCards = 0;
		for (Card card : cardsInHand) {
			sumOfCards += card.getValue();
		}
		return sumOfCards > 21;
	}

	public boolean isBlackJack() {
		if (cardsInHand.size() == 2) {
			// is true
			return cardsInHand.get(0).getValue() + cardsInHand.get(1).getValue() == 21;
		}
		return false;
	}

	@Override
	public int getHandValue() {
		int inHand = 0;
		for (Card card : cardsInHand) {
			inHand += card.getValue();
		}
		return inHand;

	}
	
	
}



