package com.skilldistillery.blackjackapp;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;
import com.skilldistillery.cardgame.entitites.Card;
import com.skilldistillery.cardgame.entitites.Deck;

public class BlackJackApp {
	Scanner userInput = new Scanner(System.in);

	private Deck deck;
	private Player player;
	private Dealer dealer;
	private BlackJackHand hand;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();

		app.launchMenu();
		app.dealerTurn();
		app.displayWinner();
	}

	public void launchMenu() {

		this.deck = new Deck();
		this.player = new Player();
		this.dealer = new Dealer();
		
		System.out.println("______________________________________________________");
		System.out.println("|                                                     |");
		System.out.println("|                 Welcome to BlackJack!               |");
		System.out.println("|_____________________________________________________|");
		System.out.println("|  Enter a number from the menu below to get started  |");
		System.out.println("|                                                     |");
		System.out.println("| 1. Lets play Blackjack!                             |");
		System.out.println("| 2. Blackjack Rules                                  |");               
		System.out.println("| 3. Watch the dealer shuffle                         |");
		System.out.println("| 4. Quit                                             |"); 
		System.out.println("|_____________________________________________________|");

		int menuChoice = userInput.nextInt();
		userInput.nextLine();
		
		switch (menuChoice) {
		
		case 1: 
			System.out.println("Let's get this party started!\n");
			startGame();
			break; 		
			
		case 2: 
			System.out.println("Let's get this party started");
			blackjackRules();
			break; 			
			
		case 3: 
			deck.showDeckShuffle(); 
			break;
		 
		case 4: 
			System.out.println("Okay, goodbye!");
			break;
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
		
		if (!player.playerHand.isBust() && !player.playerHand.isBlackJack() && !dealer.dealerHand.isBlackJack()) {
			userHitOrStay();
		}
	

	}

	// new method to hit or stay
	// must check if hand is bust
	// must check if hand is blackjack

	public void userHitOrStay() {
		
		while (!player.playerHand.isBust() && !player.playerHand.isBlackJack()) {
			
			System.out.println("Would you like to hit or stay?");
			System.out.println("Type hit or stay: "); 
			
			String choice = userInput.nextLine(); 
			


			if (choice.equalsIgnoreCase("stay")) {
				System.out.println("You chose to stay!\n");
				break;
			}

			if (player.playerHand.isBust()) {
				System.out.println("\n------------------------------ Player Bust ---------------------------------");
				break;
			}
			if (player.playerHand.isBlackJack()) {
				System.out.println("\n************************** Player Blackjack ********************************");
				break;
			}
			if (choice.equalsIgnoreCase("hit")) {
				System.out.println("You chose hit, here is your new hand: ");
				this.player.playerHand.addCard(this.deck.dealCard());
				this.player.showHand();
				
			}
			
			
		}
		
	}
	
	public void dealerTurn() {

		// User story 4: if dealer is below 17 they must hit
		while (!dealer.dealerHand.isBust() && dealer.dealerHand.getHandValue() < 17) {
			this.dealer.dealerHand.addCard(this.deck.dealCard());
		}
		if (dealer.dealerHand.isBlackJack()) {
			System.out.println("\n********** Dealer Blackajack **********");
		}
		
	}

	public void displayWinner() {
		System.out.println("\n AND THE WINNNER IS  \n");

		this.player.showHand();
		this.dealer.showHand();

		if (player.playerHand.isBust()) {
			dealer.dealerWin();

		} else if (dealer.dealerHand.isBust()) {
			player.playerWin();

		} else if (player.playerHand.isBlackJack()) {
			player.playerWin();

		} else if (dealer.dealerHand.isBlackJack()) {
			dealer.dealerWin();

		} else if (dealer.dealerHand.getHandValue() < 21 && player.playerHand.getHandValue() < 21) {

			if (player.playerHand.getHandValue() > dealer.dealerHand.getHandValue()) {
				player.playerWin();
			}
			if (dealer.dealerHand.getHandValue() > player.playerHand.getHandValue()) {
				dealer.dealerWin();

			} else if (dealer.dealerHand.getHandValue() == player.playerHand.getHandValue()) {
				System.out.println("Push! No one is a loser today!");

			}

		}
// add a return to menu option or keep playing? 

	}
	
	public void blackjackRules() {
		System.out.println( "Welcome to Blackjack, before we take all of your money we thought \n it might be fair to explain the rules and how the game work.");
		System.out.println();
		System.out.println("Blackjack, also known as \"Twenty-One\" is a fun game with simple rules. ");
		System.out.println();
		System.out.println("Rules ");
		System.out.println();
		System.out.println("The Pack, AKA The Deck:");
		System.out.println("A standard 52-pack playing deck is used for this game");
		System.out.println();
		System.out.println("Object of the Game:");
		System.out.println("Beat the dealer by getting as close to 21 as possible \nwithout going over 21.");
		System.out.println();
		System.out.println("Betting:");
		System.out.println("Before the deal begins, each player places a bet, our buy in is $20");
		System.out.println();
		System.out.println("Odds:");
		System.out.println("We have a 1.5 : 1 odds. That means for every $20 bet you could win $10");
		System.out.println("and walk away with $30. ");
		System.out.println();
		System.out.println("Card Values & Scoring:");
		System.out.println("Player decides if an Ace is a 1 or 11. Face cards are worth 10 points.\nand every other card is its pip value.");
		System.out.println();
		System.out.println("When all the players have placed their bets, the dealer gives one card face up to each player in rotation\n " 
			+"clockwise, and then one card face up to themselves. Another round of cards is then dealt face up to each\n"
			+ "player, but the dealer takes the second card face down. Thus, each player except the dealer receives two cards face up,\n "
			+ "and the dealer receives one card face up and one card face down. (In some games, played with only one deck, the players'\n "
			+ "cards are dealt face down and they get to hold them. Today, however, virtually all Blackjack games feature the players'\n "
			+ "cards dealt face up on the condition that no player may touch any cards.");
		System.out.println();
		
		System.out.println("Back to main menu? Y/N");
		String back = userInput.next(); 
		
		if(back.equalsIgnoreCase("Y") ) {
			launchMenu();
		} else {System.out.println("Good bye!");
		
		}
		
	}
}