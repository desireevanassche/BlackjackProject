package com.skilldistillery.blackjackapp;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;
import com.skilldistillery.cardgame.entitites.Deck;

public class BlackJackApp {
	Scanner userInput = new Scanner(System.in);

	private Deck deck;
	private Player player;
	private Dealer dealer;
	private BlackJackHand hand;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();

		app.launch();
		app.userHitOrStay();
	}

	public void launch() {

		this.deck = new Deck();
		this.player = new Player();
		this.dealer = new Dealer();


		System.out.println("Welceom****** EDIT ME ");
		System.out.println("Are you ready to loose all your money? Yes or No ");
		String input = userInput.nextLine();

		if (input.equalsIgnoreCase("yes")) {
			System.out.println("Let's get this party started");
			startGame();

		} else {
			System.out.println("Okay, goodbye!");
		}
	}

	private void startGame() {

		// shuffle deck
		this.deck.shuffle(); // periods are important forget a period forget about callnf your method

		// deal to player
		this.player.playerHand.addCard(this.deck.dealCard());
		this.player.playerHand.addCard(this.deck.dealCard());

		// deal to dealer
		this.dealer.dealerHand.addCard(this.deck.dealCard());
		this.dealer.dealerHand.addCard(this.deck.dealCard());

		// show player their hand
		this.player.showHand();

	}

	// new method to hit or stay
	// must check if hand is bust
	// must check if hand is blackjack

	public void userHitOrStay() {

		while (!player.playerHand.isBlackJack() || !player.playerHand.isBust()) {

			System.out.println("Would you like to hit or stay?");
			System.out.println("Type hit or stay: ");
			String choice = userInput.nextLine();

			if (choice.equalsIgnoreCase("hit")) {
				System.out.println("You chose hit, here is your new hand: ");
				this.player.playerHand.addCard(this.deck.dealCard());
				this.player.showHand();
			}
			if (choice.equalsIgnoreCase("stay")) {
				System.out.println("You chose to stay, here is your hand: ");
				this.player.showHand();
				break;
			}

			if (player.playerHand.isBust()) {
				System.out.println("BUST");
				break;
			}
			if (player.playerHand.isBlackJack()) {
				System.out.println("BLACKJACK");
				break;
			}

		}
	}
}