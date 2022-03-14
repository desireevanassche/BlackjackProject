package com.skilldistillery.blackjack.entities;

import java.util.List;

import com.skilldistillery.cardgame.entitites.Card;

public class Dealer {
	
	//create an instance of a hand
	public BlackJackHand dealerHand;
	
	public Dealer() {
		this.dealerHand = new BlackJackHand();
		
	}
//	
//	public void getHandValue(List<Card> inHand, int value) {
//		for (Card card : inHand) {
//			System.out.println(card);
//		} System.out.println("Total value of both cards: " + value);
//		
//	}
	public void dealerWin() {
		System.out.println("Dealer won this round. Better luck next time!");
	}
	
	public void showHand() {
		System.out.println("Dealer hand: ");
		System.out.println(dealerHand.getCards() + " " + dealerHand.getHandValue() + "\n");
	}

}
