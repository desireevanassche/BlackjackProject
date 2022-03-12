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

	public void showHand() {
		System.out.println("Player Hand: ");
		System.out.println(playerHand.getCards() + "\nHand point value:" + playerHand.getHandValue() + "\n");
	}

	public void playerWin() {
		System.out.println("Player Wins!");
		
	}

}
