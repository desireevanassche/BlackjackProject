package com.skilldistillery.blackjack.entities;

import java.util.List;

import com.skilldistillery.cardgame.entitites.Card;

public class Player {
	public  BlackJackHand playerHand;

	public BlackJackHand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(BlackJackHand playerHand) {
		this.playerHand = playerHand;
	}

	public Player() {
		this.playerHand = new BlackJackHand();
	}

	public void getHandValue(List<Card> inHand, int value) {
		for (Card card : inHand) {
			System.out.println(card);
		}
		System.out.println("Total value of both cards: " + value);

	}

//	public void showHand() {
//		System.out.println(playerHand.addCard(null).get(0) + "\n" + playerHand.getCards().get(1));
//	}

	public void showHand() {
		System.out.println("Your hand: " + playerHand.getCards() + " " + playerHand.getHandValue());
	}

	public void playerWin() {
		System.out.println("Congrats you have won this round!");
		System.out.println("Would you like to play again? ");
	}

}
