package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {
	
	public boolean isBust() {
		int sum = 0;
		for (Card card :)
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

//		BlackJackApp bja = new BlackJackApp();
//
//		Deck playerHand = new Deck(); // player deck
//		Deck dealerHand = new Deck();
//
//		playerHand.draw(bjDeck);
//		playerHand.draw(bjDeck);
//
//		dealerHand.draw(bjDeck);
//		dealerHand.draw(bjDeck);
//
//		System.out.println("Your cards are: ");
//		System.out.println(playerHand.toString());
//
//		// BlackJackHand hand = new BlackJackHand();
//		getHandValue(playerHand);
//
//		getDealerHandValue(dealerHand);
//
//	}
//

