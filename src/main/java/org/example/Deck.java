package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Deck implements DeckActions {
    private ArrayList<Card> myCards;

    public Deck() {
        this.myCards = new ArrayList<>();
        populateDeck();
    }

    private void populateDeck() {
        myCards.clear();
        for (Suits suit : Suits.values()) {
            for (Values value : Values.values()) {
                myCards.add(new Card(suit, value));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(myCards);
    }

    @Override
    public Card dealNextCard() {
        if (myCards.isEmpty()) {
            System.out.println("Deck is empty. Reshuffling...");
            populateDeck();
            shuffle();
        }
        return myCards.isEmpty() ? null : myCards.remove(0);
    }

    @Override
    public void printDeck(int numToPrint) {
        for (int i = 0; i < numToPrint && i < myCards.size(); i++) {
            System.out.println(myCards.get(i).toString());
        }
    }
}
