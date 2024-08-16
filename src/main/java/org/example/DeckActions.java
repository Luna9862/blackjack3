package org.example; // Declares the package name, organizing the interface into the 'org.example' package.

public interface DeckActions { // Declares the 'DeckActions' interface, defining the actions that can be performed on a deck of cards.

    // Method to shuffle the deck, randomizing the order of the cards.
    void shuffle();

    // Method to deal the next card from the deck.
    // Returns the next Card object from the deck or null if the deck is empty.
    Card dealNextCard();

    // Method to print a specified number of cards from the deck.
    // The number of cards to print is specified by the 'numToPrint' parameter.
    void printDeck(int numToPrint);
}
