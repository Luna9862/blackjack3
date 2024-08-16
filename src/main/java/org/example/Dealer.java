package org.example; // Declares the package name, organizing the class into the 'org.example' package.

import java.util.ArrayList; // Imports the ArrayList class from the Java standard library, which is used to store a dynamic list of objects.

public class Dealer { // Declares the 'Dealer' class, representing the dealer in the Blackjack game.

    private ArrayList<Card> hand; // A private field 'hand' that stores the dealer's current hand of cards as an ArrayList of Card objects.

    public Dealer() { // Constructor for the 'Dealer' class, used to create a new dealer object.
        this.hand = new ArrayList<>(); // Initializes the 'hand' field with an empty ArrayList to store the cards in the dealer's hand.
    }

    public void addCardToHand(Card card) { // A public method 'addCardToHand' that adds a card to the dealer's hand.
        hand.add(card); // Adds the specified 'card' to the 'hand' ArrayList.
    }

    public ArrayList<Card> getHand() { // A public method 'getHand' that returns the dealer's current hand of cards.
        return hand; // Returns the 'hand' field, which is the list of cards in the dealer's hand.
    }

    public int getHandValue() { // A public method 'getHandValue' that calculates and returns the total value of the dealer's hand.
        int value = 0; // Initializes a variable 'value' to store the total value of the hand.
        int aceCount = 0; // Initializes a variable 'aceCount' to track the number of Aces in the hand.

        for (Card card : hand) { // Loops through each card in the dealer's hand.
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

        return value; // Returns the final calculated value of the dealer's hand.
    }

    public boolean hasBlackjack() { // A public method 'hasBlackjack' that checks if the dealer has Blackjack (a hand value of 21 with exactly two cards).
        return getHandValue() == 21 && hand.size() == 2; // Returns true if the dealer's hand value is 21 and contains exactly two cards, indicating Blackjack.
    }
}
