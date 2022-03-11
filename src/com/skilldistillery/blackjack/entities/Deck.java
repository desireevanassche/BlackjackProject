package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public void createDeck() {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				this.cards.add(new Card(suit, rank));

	}

	public String toString() {
		String cardOutput = "";
		int i = 0; // this is to test
		for (Card idxCard : this.cards) {
			cardOutput += "\n" + idxCard.toString(); 
			i++; // this is also to test remove all i's later
		}
		return cardOutput;
	}

////	Collections.shuffle version 
//	public void shuffle() {
//		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
//		int originalSize = this.cards.size();
//
//		for(int i = 0; i < originalSize; i++ ) {
//			shuffledDeck.add(this.cards.get(i));
//		}
//		
//			Collections.shuffle(this.cards);
//			this.cards = shuffledDeck; 
//		}

	public void shuffle2() { // math.random version

		ArrayList<Card> shuffledDeck = new ArrayList<Card>();

		Random random = new Random();
		int randIndex = 0;
		int originalSize = this.cards.size();

		for (int i = 0; i < originalSize; i++) {
			// generate random index
			// rand.nextInt((max-min) +1) + min;
			randIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
			shuffledDeck.add(this.cards.get(randIndex));
			// remove from original deck
			this.cards.remove(randIndex);

		}

		this.cards = shuffledDeck;
	}

	public void removeCard(int remIdx) {
		this.cards.remove(remIdx);
	}

	public Card getCard(int getIdx) {
		return this.cards.get(getIdx);
	}

	public void addCardBack(Card addCard) {
		this.cards.add(addCard);
	}

	// this says take the first card similar to drawing from the top of our deck
	public void draw(Deck derived) {
		this.cards.add(derived.getCard(0));
		derived.removeCard(0); // think one in one out
	}

		} 


