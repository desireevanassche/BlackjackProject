package com.skilldistillery.blackjack.entities;

public class BlackJackBet {
	private double balance;
	private double bet;

	public BlackJackBet() {

	}

	public BlackJackBet(double balance, double bet) {
		this.balance = balance;
		this.bet = bet;

	}

	public void blackjackBet() {
		System.out.println("Welcome to Blackjack Bet!");
		System.out.println("Hope you are feeling lucky today!");
		System.out.println("How much would you like to deposit into your bet bank?");
	}

	public void setBalance(double deposit) {
		System.out.println("You have " + deposit + " available.");
		balance = deposit;
	}

	public void setBet(double betAmount) {
		this.bet = betAmount;
		System.out.println("You are betting $" + bet);
	}
	
	public void balanceAfterBet() {
		balance -= bet; 
	}

	public void displayWin() {
		double withBet = (bet * 1.5);
		double totalWin = withBet - bet;
		System.out.println("You won $" + totalWin);
	}

	public void addWinnings() {
		balance += (bet * 1.5);
		System.out.println("You now have $" + balance + " in your account.");
	}

	public void subtractLoss() {
		balance -= bet;
		System.out.println("You have" + balance + " remaining in your bank.");
	}

	public double getBalance() {
		return balance;
	}

	public boolean isOutOfMoney() {
		// if ()
		return false;

	}
	
}
