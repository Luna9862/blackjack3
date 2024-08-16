package org.example; // Declares the package name, organizing the class into the 'org.example' package.

import java.util.ArrayList; // Imports the ArrayList class from the Java standard library, which is used to store a dynamic list of objects.
import java.util.Collections; // Imports the Collections class from the Java standard library, providing utility methods like shuffle.

public class Deck implements DeckActions { // Declares the 'Deck' class, representing a deck of cards, and implements the 'DeckActions' interface.
    private ArrayList<Card> myCards; // A private field 'myCards' that stores the deck's cards as an ArrayList of Card objects.

    public Deck() { // Constructor for the 'Deck' class, used to create a new deck object.
        this.myCards = new ArrayList<>(); // Initializes the 'myCards' field with an empty ArrayList to store the cards in the deck.
        populateDeck(); // Calls the 'populateDeck' method to fill the deck with a full set of cards.
    }

    private void populateDeck() { // A private method 'populateDeck' that populates the deck with a full set of cards.
        myCards.clear(); // Clears any existing cards from the deck (if any).
        for (Suits suit : Suits.values()) { // Loops through each suit (Hearts, Diamonds, Clubs, Spades) in the Suits enum.
            for (Values value : Values.values()) { // Loops through each value (2, 3, ..., King, Ace) in the Values enum.
                myCards.add(new Card(suit, value)); // Creates a new Card object for each combination of suit and value and adds it to the deck.
            }
        }
    }

    @Override // Indicates that this method overrides a method in the implemented interface.
    public void shuffle() { // A public method 'shuffle' that shuffles the deck of cards.
        Collections.shuffle(myCards); // Uses the 'shuffle' method from the Collections class to randomly reorder the cards in the deck.
    }

    @Override // Indicates that this method overrides a method in the implemented interface.
    public Card dealNextCard() { // A public method 'dealNextCard' that deals the next card from the deck.
        if (myCards.isEmpty()) { // Checks if the deck is empty (no cards left).
            System.out.println("Deck is empty. Reshuffling..."); // Prints a message indicating the deck is empty and will be reshuffled.
            populateDeck(); // Calls the 'populateDeck' method to refill the deck with a new set of cards.
            shuffle(); // Shuffles the newly populated deck.
        }
        return myCards.isEmpty() ? null : myCards.remove(0); // Returns the top card from the deck (removing it from the deck), or null if the deck is still empty.
    }

    @Override // Indicates that this method overrides a method in the implemented interface.
    public void printDeck(int numToPrint) { // A public method 'printDeck' that prints a specified number of cards from the deck.
        for (int i = 0; i < numToPrint && i < myCards.size(); i++) { // Loops through the deck, up to the specified number of cards or the number of cards in the deck.
            System.out.println(myCards.get(i).toString()); // Prints the string representation of each card.
        }
    }
}
