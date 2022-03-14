# BlackjackProject


## Description
This Object Oriented Java program is designed to play a fun game of Blackjack, also commonly known as Twenty-One. Who knew applying concepts of inheritance, polymorphism, and encapsulation could be so fun?

This program has common elements that may be utilized in many different card applications, the most valuable being the Deck, which is made from an ArrayList of object Card. The Card object is created with Enumerators Suit and Rank as fields. Iterating through the Suit and Rank Enumerators values while building the Deck of cards allowed an efficient and constant Deck to be created.

Once the deck is created the real fun begins. Two cards are dealt to both the Player and Dealer. These cards are then stored in their corresponding BlacjackHand which is a subclass of the abstract Superclass Hand. The player is shown their hand and given the options to either "Hit" or "Stay" with the goal of getting close to 21 total points without going over. The player may "Hit" as many times as they would like and are dealt a new card each time. The Dealer follows house logic, if their Hand is less than 17 they "Hit", and are dealt another card if they are over 17 they "Stay". If at any time either the Player or Dealer goes over 21(bust), or get Blackjack (21 on the first hand of cards) the game is over and the winner is announced.


## Technologies Used
* Encapsulation
* Object Oriented Programing
* Inheritance
* Abstract Superclass
* UML Diagram
* Conditionals
* Enumerators
* ArrayList
* Polymorphism
* Switch menus
* Java Utility Package
* Eclipse


## Lessons Learned

### Git for Every Working Code
While working on enhancing my project I made a mistake, one that caused my program to skip over the methods "isBust" or 'isBlackjack'. After a scan of the program, I was unable to find the error. Thankfully I had committed my program to Github. This saved what I would imagine being countless hours of backtracking, and allowed me to make a copy of the new code I wanted to implement while effortlessly copying my functioning code back to my application.

### Clear the Scanner
This is hardly a new lesson, but it is one that came back around to bite me once again. This means that this time I am documenting it. In our Food Truck project, we have been explained the importance of clearing the Scanner. This week I experienced the consequences of forgetting to clear the Scanner. I had a line of code repeating itself twice, a line that was in a different method. With the help of the staff, I was able to identify the error in my code and resolve it. Sometimes you have to learn the hard way for the lesson to stick.

### What Do You Want to Achieve?
I've accepted that coding is challenging, but I have learned that there are techniques that make it, dare I say... easier. Making sense of what I am trying to achieve has simplified things greatly. I call this planning before implementing and it's something I am glad my teachers have taught me. Taking the time to ask myself "What is our goal for this part of the code?" Writing the answer to that goal, implementing it into my UML, along with some scribbles of ideas of how to make it work has saved me tons of time and brainpower.

## Project Requirements
User Story #1
Create a class structure that mimics a deck of cards. Remember decks as well as hands are made up of cards. Feel free to create the structure in any way you see fit.

Your card and deck implementations should NOT be coupled to Blackjack; you should be able to reuse them to implement a poker or bridge game application.

User Story #2
Add methods and fields to your classes that mimic the functionality of shuffling and dealing a deck of cards. Remember that when a card is dealt you have to remove it from the current deck. You should be able to print out a shuffled deck to the terminal.

User Story #3
Deal two hands of cards - one to a Dealer and another to a Player. Allow the players to Hit (add cards to their hand) or Stay (not add cards to their hand) in accordance to the rules of blackjack shown in the wiki.

Do not worry about the multiple values for Ace until your basic game logic is working. Assume they are either 1 or 11 to start.

User Story #4
The Dealer's decisions are based on game logic in the program.

The Dealer must decide to Hit or Stay based on the rules of Blackjack: if the Dealer's hand total is below 17, the Dealer must Hit; if the hand total is 17 or above, the Dealer must Stay.

User Story #5
Determine the winner of each round by implementing the remaining rules of Blackjack (such as going over 21) and comparing hand values.
