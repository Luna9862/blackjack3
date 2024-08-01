package org.example;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private double balance;

    public Player() {
        this.hand = new ArrayList<>();
        this.balance = 1000.0; // Starting balance
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public double getBalance() {
        return balance;
    }

    public void adjustBalance(double amount) {
        this.balance += amount;
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
}
