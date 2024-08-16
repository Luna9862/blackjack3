package org.example; // Declares the package name, organizing the class into the 'org.example' package.

public class Card { // Declares the 'Card' class, representing a single playing card in a deck.

    private Suits suit; // A private field 'suit' that stores the suit (hearts, diamonds, clubs, spades) of the card.
    private Values value; // A private field 'value' that stores the value (2, 3, 4,..., 10, Jack, Queen, King, Ace) of the card.

    public Card(Suits suit, Values value) { // Constructor for the 'Card' class, used to create a new card with a specific suit and value.
        this.suit = suit; // Initializes the 'suit' field with the value passed to the constructor.
        this.value = value; // Initializes the 'value' field with the value passed to the constructor.
    }

    public Suits getSuit() { // A public method 'getSuit' that returns the suit of the card.
        return suit; // Returns the 'suit' field, which represents the card's suit.
    }

    public Values getValue() { // A public method 'getValue' that returns the value of the card.
        return value; // Returns the 'value' field, which represents the card's value.
    }

    @Override // Indicates that the following method overrides a method from the parent class (in this case, the Object class).
    public String toString() { // A public method 'toString' that returns a string representation of the card.
        return value.getValue() + " of " + suit; // Returns a string that describes the card, combining its value and suit (e.g., "Ace of Spades").
    }
}
