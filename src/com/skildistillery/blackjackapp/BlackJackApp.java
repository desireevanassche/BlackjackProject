package com.skildistillery.blackjackapp;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	Scanner userInput = new Scanner(System.in);

	private Deck deck;
	private Player player;
	private Dealer dealer;
	private BlackJackHand hand;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();

		app.launch();
		app.startGame();
		app.userHitOrStay();
	}

	public void launch() {
		this.deck = new Deck();
		this.player = new Player();
		this.dealer = new Dealer();


		System.out.println("Welceom****** EDIT ME ");
		System.out.println("Are you ready to loose all your money? Yes or No ");
		String input = userInput.nextLine();

		if (input.equalsIgnoreCase("no")) {
			System.out.println("Okay, goodbye!");
		} else {
			System.out.println("Let's get thid psy started");

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
	//must check if hand is blackjack 

	public void userHitOrStay() {

		
		System.out.println("Would you like to hit or stay?");
		System.out.println("Type hit or stay: ");
		String choice = userInput.nextLine();

		if (choice.equalsIgnoreCase("Hit")) {
			this.player.playerHand.addCard(this.deck.dealCard());
			this.player.showHand();
		} else if (choice.equalsIgnoreCase("Stay")) {
			System.out.println("You chose to stay.");
			this.player.showHand();
		} 
	}
	}
