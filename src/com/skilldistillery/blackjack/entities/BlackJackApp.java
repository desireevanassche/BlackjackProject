package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class BlackJackApp {

	Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.launchGame();
	

	}

		// BlackJackHand bjHand = new BlackJackHand();

		//// *** TESTING OUT PRINT
	//	System.out.println(bjDeck);
		/// **** USE LATER TO OUTPRINT THE SHUFFLED DECK, USER STORY 2

//			attemping to pass the players deck to the BlackJackHand 
//			

//		Deck playerHand = new Deck(); // player deck
//		Deck dealerHand = new Deck(); // house deck
		

			// pass the deck to the BlackJack hand?
			// or only the hand to check value?

			// deal the player two cards
//			playerHand.draw(bjDeck);
//			playerHand.draw(bjDeck);
//
//			// deal the dealer two cards
//			dealerHand.draw(bjDeck);
//			dealerHand.draw(bjDeck);

			// add cards to players hand
				
				//passDeck.getHandValue(playerHand);
				//passDeck.getHandValue(dealerHand); // change to not diplay 

//				System.out.println("Your cards are: " );
//				System.out.println(playerHand.toString());
//					
	
	
	public void launchGame() {
		double playerBank = 100;
		
		System.out.println("Welcome to Blackjack! ");
		
		while (playerBank > 0) {
			Deck gameDeck = new Deck(); // instantiate
			gameDeck.createDeck(); // this creates the deck for blackjack and populates it
			gameDeck.shuffle2();

			System.out.println("You have " + playerBank + ",in your bankroll. \nHow much would you like ot bet?");
			double playerBet = kb.nextDouble();
			
			
			if (playerBet > playerBank) {
				System.out.println("You can't bet money you don't have.");
				break;
			}
			while (true) {
				BlackJackHand passDeck = new BlackJackHand();
				passDeck.addCard(gameDeck); 
			break;
			}
		}			
			System.out.println("Better luck next time!");
	}	
	}
			// print cards out
			// hit or ?
			
		
		
		
	


