package org.example; // Declares the package name, organizing the class into the 'org.example' package.

import java.util.ArrayList; // Imports the ArrayList class from the Java standard library, which is used to store a dynamic list of objects.

public class Player { // Declares the 'Player' class, representing the player in the Blackjack game.

    private ArrayList<Card> hand; // A private field 'hand' that stores the player's current hand of cards as an ArrayList of Card objects.
    private double balance; // A private field 'balance' that stores the player's current balance (amount of money they have).

    public Player() { // Constructor for the 'Player' class, used to create a new player object.
        this.hand = new ArrayList<>(); // Initializes the 'hand' field with an empty ArrayList to store the cards in the player's hand.
        this.balance = 1000.0; // Initializes the 'balance' field with a starting balance of 1000.0.
    }

    public void addCardToHand(Card card) { // A public method 'addCardToHand' that adds a card to the player's hand.
        hand.add(card); // Adds the specified 'card' to the 'hand' ArrayList.
    }

    public ArrayList<Card> getHand() { // A public method 'getHand' that returns the player's current hand of cards.
        return hand; // Returns the 'hand' field, which is the list of cards in the player's hand.
    }

    public double getBalance() { // A public method 'getBalance' that returns the player's current balance.
        return balance; // Returns the 'balance' field, which is the amount of money the player has.
    }

    public void adjustBalance(double amount) { // A public method 'adjustBalance' that adjusts the player's balance by a specified amount.
        this.balance += amount; // Adds the specified 'amount' to the player's balance. The amount can be positive (to increase the balance) or negative (to decrease the balance).
    }

    public int getHandValue() { // A public method 'getHandValue' that calculates and returns the total value of the player's hand.
        int value = 0; // Initializes a variable 'value' to store the total value of the hand.
        int aceCount = 0; // Initializes a variable 'aceCount' to track the number of Aces in the hand.

        for (Card card : hand) { // Loops through each card in the player's hand.
            String cardValue = card.getValue().getValue(); // Retrieves the string representation of the card's value.

            if (cardValue.equals("Ace")) { // Checks if the card is an Ace.
                aceCount++; // Increments the 'aceCount' since an Ace is found.
                value += 11; // Adds 11 to the total value for the Ace (considering it as 11 initially).
            } else if (cardValue.equals("King") || cardValue.equals("Queen") || cardValue.equals("Jack")) { // Checks if the card is a face card (King, Queen, or Jack).
                value += 10; // Adds 10 to the total value for face cards.
            } else { // For number cards (2 through 10).
                value += Integer.parseInt(cardValue); // Converts the string representation of the card's value to an integer and adds it to the total value.
            }
        }

        while (value > 21 && aceCount > 0) { // If the total value exceeds 21 and there are Aces in the hand, adjust the value.
            value -= 10; // Subtracts 10 from the total value for each Ace, considering it as 1 instead of 11.
            aceCount--; // Decrements the 'aceCount' since one Ace has been adjusted.
        }

        return value; // Returns the final calculated value of the player's hand.
    }

    public boolean hasBlackjack() { // A public method 'hasBlackjack' that checks if the player has Blackjack (a hand value of 21 with exactly two cards).
        return getHandValue() == 21 && hand.size() == 2; // Returns true if the player's hand value is 21 and contains exactly two cards, indicating Blackjack.
    }
}
