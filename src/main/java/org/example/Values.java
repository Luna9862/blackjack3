package org.example; // Declares the package name, organizing the class into the 'org.example' package.

public enum Values { // Declares the 'Values' enum, representing the possible values of a card in a deck.

    // Enumerates the possible values a card can have in a standard deck, each associated with a string representation.
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
    EIGHT("8"), NINE("9"), TEN("10"), JACK("Jack"), QUEEN("Queen"),
    KING("King"), ACE("Ace");

    private final String value; // A private final field 'value' that stores the string representation of the card's value.

    Values(String value) { // Constructor for the 'Values' enum, used to associate a string representation with each enum constant.
        this.value = value; // Initializes the 'value' field with the string passed to the constructor.
    }

    public String getValue() { // A public method 'getValue' that returns the string representation of the card's value.
        return value; // Returns the 'value' field, which represents the card's value as a string.
    }
}
