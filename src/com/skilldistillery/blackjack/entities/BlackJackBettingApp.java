package com.skilldistillery.blackjack.entities;

	
	import java.util.Scanner;

	import com.skilldistillery.blackjack.entities.BlackJackBet;
	import com.skilldistillery.blackjack.entities.BlackJackHand;
	import com.skilldistillery.blackjack.entities.Dealer;
	import com.skilldistillery.blackjack.entities.Player;
	import com.skilldistillery.cardgame.entitites.Deck;

	public class BlackJackBettingApp {
		Scanner userInput = new Scanner(System.in);

		private Deck deck;
		private Player player;
		private Dealer dealer;
		private BlackJackHand blackHand;
		private static boolean playAgain = true;
		private BlackJackBet betGame; 

		public static void main(String[] args) {
			BlackJackBettingApp app = new BlackJackBettingApp();

			while (playAgain = true) {
				app.launchMenu();
				app.userHitOrStay();
				app.dealerTurn();
				app.displayWinner();
				app.playAnotherRound();
			}
		}

		public void launchMenu() {

			this.deck = new Deck();
			this.player = new Player();
			this.dealer = new Dealer();
			this.betGame = new BlackJackBet();

			System.out.println("______________________________________________________");
			System.out.println("|                                                     |");
			System.out.println("|                 Welcome to BlackJack!               |");
			System.out.println("|_____________________________________________________|");
			System.out.println("|  Enter a number from the menu below to get started  |");
			System.out.println("|                                                     |");
			System.out.println("| 1. Lets play Blackjack!                             |");
			System.out.println("| 2. Play Blackjack bet!                              |");
			System.out.println("| 3. Blackjack Rules                                  |");
			System.out.println("| 4. Watch the dealer shuffle                         |");
			System.out.println("| 5. Quit                                             |");
			System.out.println("|_____________________________________________________|");

			int menuChoice = userInput.nextInt();
			userInput.nextLine();

			switch (menuChoice) {

			case 1:
				System.out.println("Let's get this party started!\n");
				startGame();
				break;
				
			case 2: 
				
				blackjackBetGameMethodCalls();
				
				
				break;

			case 3:
				System.out.println("Let's get this party started");
				blackjackRules();
				break;

			case 4:
				deck.showDeckShuffle();
				break;

			case 5:
				System.out.println("Okay, goodbye!");
				break;
			}
		}
		
		private void blackjackBetGameMethodCalls() {
			
			betGame.blackjackBet();  //launch menu blackjackBetGameMethodCalls()
			betDeposit();
			bet();
			startGame();
			userHitOrStay();
			dealerTurn();
			displayWinnerBetting();
			
		}

		private void startGame() {

			// shuffle deck
			this.deck.shuffle(); 
			// deal to player
			this.player.playerHand.addCard(this.deck.dealCard());
			this.player.playerHand.addCard(this.deck.dealCard());

			// deal to dealer
			this.dealer.dealerHand.addCard(this.deck.dealCard());
			this.dealer.showHand();
			
			this.dealer.dealerHand.addCard(this.deck.dealCard());

			// show player their hand
			this.player.showHand();
			// if (!player.playerHand.isBust() && !player.playerHand.isBlackJack() &&
			// !dealer.dealerHand.isBlackJack()) {
			// userHitOrStay();
		}


		
		public void userHitOrStay() {

			while (!player.playerHand.isBust() && !player.playerHand.isBlackJack()) {

				System.out.println("Would you like to hit or stay?");
				System.out.println("Type 1:Hit or 2:Stay: ");

				int choice = userInput.nextInt();
				userInput.nextLine();

				if (choice == 2) {
					System.out.println("You chose to stay!\n");
					break;

				}
				if (choice == 1) {
					System.out.println("You chose hit, here is your new hand: ");
					this.player.playerHand.addCard(this.deck.dealCard());
					this.player.showHand();

				}

				if (player.playerHand.getHandValue() == 21) {
					System.out.println("Player Blackjack!");
					break;
				}

			}

		}
		
		public void betDeposit() {
			double deposit = userInput.nextDouble();
			userInput.nextLine();
			this.betGame.setBalance(deposit);	
		}
		
		public void bet() {
			
			
			System.out.println("How much would you like to bet? ");
			double betAmount = userInput.nextDouble();
			userInput.nextLine();
			
			betGame.setBet(betAmount);
			
			
			
			
			//don't forget to flush 
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

		public void displayWinnerBetting() {

			this.player.showHand();
			this.dealer.showHand();

			if (player.playerHand.isBust()) {
				System.out.println("Player bust!");
				dealer.dealerWin();
				betGame.subtractLoss();
				

			} else if (dealer.dealerHand.isBust()) {
				player.playerWin();
				betGame.displayWin();
				betGame.addWinnings();

			} else if (player.playerHand.isBlackJack()) {
				System.out.println("Player Blackjack!");
				player.playerWin();
				betGame.displayWin();
				betGame.addWinnings();

			} else if (dealer.dealerHand.isBlackJack()) {
				dealer.dealerWin();
				betGame.subtractLoss();

			} else if (dealer.dealerHand.getHandValue() < 21 && player.playerHand.getHandValue() < 21) {

				if (player.playerHand.getHandValue() > dealer.dealerHand.getHandValue()) {
					player.playerWin();
					betGame.displayWin();
					betGame.addWinnings();
				}
				if (dealer.dealerHand.getHandValue() > player.playerHand.getHandValue()) {
					dealer.dealerWin();
					betGame.subtractLoss();

				} else if (dealer.dealerHand.getHandValue() == player.playerHand.getHandValue()) {
					System.out.println("Push! No one is a loser today!");

				}
				anotherGameBetting();
			}
		}

		public void playAnotherRound() {
			System.out.println("Would you like to play another round? Y/N");
			String again = userInput.nextLine();
			//userInput.nextLine();
			
			if (again.equalsIgnoreCase("Y")) {
				playAgain = true;
			} else {
				System.out.println("Goodbye!");
				playAgain = false;
			}

			player.playerHand.discardHand();
			dealer.dealerHand.discardHand();
		}
		
		public void anotherGameBetting() {
			
			System.out.println("Would you like to play another round? Y/N");
			String another = userInput.nextLine();
			//userInput.nextLine();
			
			if (another.equalsIgnoreCase("Y")) {
				
				bet();
				startGame();
				userHitOrStay();
				dealerTurn();
				displayWinnerBetting();
				
			} else {
				System.out.println("Goodbye!");
				playAgain = false;
			}

			player.playerHand.discardHand();
			dealer.dealerHand.discardHand();
			
		}
		
		
		public void displayWinner() {

			this.player.showHand();
			this.dealer.showHand();

			if (player.playerHand.isBust()) {
				System.out.println("Player bust!");
				dealer.dealerWin();

			} else if (dealer.dealerHand.isBust()) {
				player.playerWin();

			} else if (player.playerHand.isBlackJack()) {

				System.out.println("Player Blackjack!");
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

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		public void blackjackRules() {
			System.out.println(
					"Welcome to Blackjack, before we take all of your money we thought \n it might be fair to explain the rules and how the game work.");
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
			System.out.println(
					"Player decides if an Ace is a 1 or 11. Face cards are worth 10 points.\nand every other card is its pip value.");
			System.out.println();
			System.out.println(
					"When all the players have placed their bets, the dealer gives one card face up to each player in rotation\n "
							+ "clockwise, and then one card face up to themselves. Another round of cards is then dealt face up to each\n"
							+ "player, but the dealer takes the second card face down. Thus, each player except the dealer receives two cards face up,\n "
							+ "and the dealer receives one card face up and one card face down. (In some games, played with only one deck, the players'\n "
							+ "cards are dealt face down and they get to hold them. Today, however, virtually all Blackjack games feature the players'\n "
							+ "cards dealt face up on the condition that no player may touch any cards.");
			System.out.println();

			System.out.println("Back to main menu? Y/N");
			String back = userInput.nextLine();
			//userInput.nextLine(); //*******************ADDDEDD FLUSH 
			

			if (back.equalsIgnoreCase("Y")) {
				startGame();
			} else {
				System.out.println("Good bye!");

			}
			
			
			
			
			
			
		
			
			

		}
	}

