package org.example;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            String cardValue = card.getValue().getValue();

            if (cardValue.equals("Ace")) {
                aceCount++;
                value += 11;
            } else if (cardValue.equals("King") || cardValue.equals("Queen") || cardValue.equals("Jack")) {
                value += 10;
            } else {
                value += Integer.parseInt(cardValue);
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public boolean hasBlackjack() {
        return getHandValue() == 21 && hand.size() == 2;
    }
}
